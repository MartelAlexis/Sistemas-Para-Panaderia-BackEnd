package com.Sistemas_Para_Panaderia_BackEnd.services;

import com.Sistemas_Para_Panaderia_BackEnd.dtos.RegisterRequest;
import com.Sistemas_Para_Panaderia_BackEnd.entities.User;
import com.Sistemas_Para_Panaderia_BackEnd.enums.Role;
import com.Sistemas_Para_Panaderia_BackEnd.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Sistemas_Para_Panaderia_BackEnd.config.JwtService;
import com.Sistemas_Para_Panaderia_BackEnd.dtos.AuthResponse;
import com.Sistemas_Para_Panaderia_BackEnd.dtos.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        String otp = generateOtp();
        User user = User.builder()
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.COMPRADOR)
                .status("INACTIVO")
                .otpCode(otp)
                .otpExpiration(LocalDateTime.now().plusMinutes(10))
                .build();

        userRepository.save(user);

        emailService.sendOtpEmail(user.getEmail(), otp);

        return "Registro exitoso. Por favor revisa tu correo electrónico para verificar tu cuenta.";
    }
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus())
                .build();
    }

    private String generateOtp() {
        return String.format("%06d", new java.util.Random().nextInt(999999));
    }
}
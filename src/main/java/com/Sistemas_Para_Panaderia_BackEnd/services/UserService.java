package com.Sistemas_Para_Panaderia_BackEnd.services;

import com.Sistemas_Para_Panaderia_BackEnd.dtos.UserProfileDTO;
import com.Sistemas_Para_Panaderia_BackEnd.entities.User;
import com.Sistemas_Para_Panaderia_BackEnd.dtos.UpdateProfileRequestDTO;
import com.Sistemas_Para_Panaderia_BackEnd.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserProfileDTO getMyProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return mapToUserProfileDTO(user);
    }

    private UserProfileDTO mapToUserProfileDTO(User user) {
        return UserProfileDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }

    public UserProfileDTO updateMyProfile(String email, UpdateProfileRequestDTO request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setFirstName(request.getFirstName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        userRepository.save(user);

        return mapToUserProfileDTO(user);
    }
}
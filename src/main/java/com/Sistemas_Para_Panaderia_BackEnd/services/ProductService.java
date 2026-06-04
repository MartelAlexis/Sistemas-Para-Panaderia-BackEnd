package com.Sistemas_Para_Panaderia_BackEnd.services;

import com.Sistemas_Para_Panaderia_BackEnd.dtos.ProductResponseDTO;
import com.Sistemas_Para_Panaderia_BackEnd.entities.Product;
import com.Sistemas_Para_Panaderia_BackEnd.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return mapToResponseDTO(product);
    }

    public List<ProductResponseDTO> getAvailableProducts() {
        return productRepository.findByStatus("DISPONIBLE").stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

}
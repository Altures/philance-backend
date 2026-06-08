package br.com.philance.backend.DTO;

public record EditProfileDTO(Long id_address,
                             String username,
                             String phone,
                             String description,
                             String password) { }
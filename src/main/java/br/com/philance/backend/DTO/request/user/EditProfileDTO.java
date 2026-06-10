package br.com.philance.backend.DTO.request.user;

public record EditProfileDTO(Long id_address,
                             String username,
                             String phone,
                             String description,
                             String password) { }
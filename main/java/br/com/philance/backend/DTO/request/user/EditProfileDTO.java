package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;

public record EditProfileDTO(
        @NotBlank
        String id_address,
        @NotBlank
        String username,
        @NotBlank
        String phone,
        @NotBlank
        String description,
        String password
) { }
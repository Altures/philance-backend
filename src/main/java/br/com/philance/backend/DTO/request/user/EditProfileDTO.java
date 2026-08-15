package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;

public record EditProfileDTO(
        @NotBlank
        String id_address,
        @NotBlank
        String id_user,
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String description,
        @NotBlank
        String password,
        @NotBlank
        String document,

        @NotBlank
        String zip_code,
        @NotBlank
        String street,
        @NotBlank
        String number,
        @NotBlank
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state
) { }
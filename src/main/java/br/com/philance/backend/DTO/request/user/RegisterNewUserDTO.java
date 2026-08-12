package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterNewUserDTO(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String birthday,
        @NotNull
        Character type,
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
) {
}



package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;
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
        @NotBlank
        Character type,
        @NotBlank
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")
        String password,
        @NotBlank
        @Pattern(regexp = "^(\\d{11}|\\d{8})$")
        String document,

        @NotBlank
        @Pattern(regexp = "^\\\\d{5}-\\\\d{3}$")
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



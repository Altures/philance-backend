package br.com.philance.backend.DTO.request.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewAddressDTO(
        @NotBlank
        @Pattern(regexp = "^\\\\d{8}$")
        String zip_code,
        @NotBlank
        String street,
        @NotBlank
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String id_user
) {
}

package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}

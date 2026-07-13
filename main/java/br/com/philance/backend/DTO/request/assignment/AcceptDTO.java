package br.com.philance.backend.DTO.request.assignment;

import jakarta.validation.constraints.NotBlank;

public record AcceptDTO(
        @NotBlank
        String id_assignment,
        @NotBlank
        String id_user
) {}
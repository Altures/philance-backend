package br.com.philance.backend.DTO.request.cancelationHistory;

import jakarta.validation.constraints.NotBlank;

public record CancelDTO(
        @NotBlank
        String id_assignment,
        @NotBlank
        String id_user,
        String reason
) {}
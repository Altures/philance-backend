package br.com.philance.backend.DTO.request.assignment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EditAssignmentDTO(
        @NotBlank
        String id_address,
        @NotBlank
        @Size(min = 50)
        String description,
        @NotNull
        @Positive
        Double payment,
        @NotNull
        Integer min_age,
        String attire
) {}
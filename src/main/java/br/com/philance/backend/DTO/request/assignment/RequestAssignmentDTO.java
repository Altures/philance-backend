package br.com.philance.backend.DTO.request.assignment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RequestAssignmentDTO(
        @NotBlank
        String id_company,
        @NotBlank
        String id_address,
        @NotBlank
        String title,
        @NotBlank
        @Size(min = 50)
        String description,
        @NotNull
        @Positive
        Float payment,
        Integer min_age,
        @NotBlank
        String attire,
        @NotBlank
        String id_tag,
        @NotBlank
        String start_hour,
        @NotBlank
        String finish_hour
        ) {}
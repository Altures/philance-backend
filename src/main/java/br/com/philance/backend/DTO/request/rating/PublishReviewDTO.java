package br.com.philance.backend.DTO.request.rating;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PublishReviewDTO(
        @NotBlank
        String id_assignment,
        @NotBlank
        String id_author,
        @NotBlank
        String id_target,
        @NotNull
        Integer review,
        String comments
){}
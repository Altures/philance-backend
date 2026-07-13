package br.com.philance.backend.DTO.request.tag;

import jakarta.validation.constraints.NotBlank;

public record RemoveTagDTO(
        @NotBlank
        String id_user,
        @NotBlank
        String id_tag

) {}
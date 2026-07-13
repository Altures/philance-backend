package br.com.philance.backend.DTO.request.tag;

import jakarta.validation.constraints.NotBlank;

//Used to apply a tag to a user or an assignment
public record ApplyTagDTO(
        @NotBlank
        String idUser,
        @NotBlank
        String idTag
) {}
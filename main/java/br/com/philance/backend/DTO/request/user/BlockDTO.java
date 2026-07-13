package br.com.philance.backend.DTO.request.user;

import jakarta.validation.constraints.NotBlank;

public record BlockDTO (
        @NotBlank
        String id_user,
        @NotBlank
        String id_block){}
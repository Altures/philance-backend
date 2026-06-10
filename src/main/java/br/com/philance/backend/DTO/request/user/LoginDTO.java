package br.com.philance.backend.DTO.request;

public record LoginDTO(
        String email,
        String password
) {
}

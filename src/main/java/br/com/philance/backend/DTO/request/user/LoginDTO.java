package br.com.philance.backend.DTO.request.user;

public record LoginDTO(
        String email,
        String password
) {
}

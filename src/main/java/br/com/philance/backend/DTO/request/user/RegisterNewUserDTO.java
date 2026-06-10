package br.com.philance.backend.DTO.request.user;

public record RegisterNewUserDTO(
        String username,
        String email,
        String phone,
        String birthday,
        char type,
        String password,
        String document
) {
}



package br.com.philance.backend.DTO.request.user;

public record RegisterNewUserDTO(
        String username,
        String email,
        String phone,
        String birthday,
        Character type,
        String password,
        String document
) {
}



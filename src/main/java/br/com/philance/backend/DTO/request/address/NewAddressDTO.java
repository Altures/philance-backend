package br.com.philance.backend.DTO.request.address;

public record NewAddressDTO(
        String zip_code,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String id_user
) {
}

package br.com.philance.backend.DTO.response.address;

public record AddressInfoDTO(
        String id,
        String zipCode,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state
) {
}

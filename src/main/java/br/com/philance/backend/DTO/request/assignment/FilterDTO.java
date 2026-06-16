package br.com.philance.backend.DTO.request.assignment;

import java.time.LocalDateTime;

public record FilterDTO(
    String address,
    Float payment,
    Integer min_age,
    LocalDateTime startHour,
    String id_tag
) {

}

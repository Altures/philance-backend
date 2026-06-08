package br.com.philance.backend.DTO;

public record CancelDTO(Long id_assignment,
                        Long id_user,
                        String reason) {}
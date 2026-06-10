package br.com.philance.backend.DTO.request.cancelationHistory;

public record CancelDTO(Long id_assignment,
                        Long id_user,
                        String reason) {}
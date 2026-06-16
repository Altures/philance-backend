package br.com.philance.backend.DTO.request.cancelationHistory;

public record CancelDTO(String id_assignment,
                        String id_user,
                        String reason) {}
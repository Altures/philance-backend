package br.com.philance.backend.DTO;

public record EditAssignmentDTO(Long id_address,
                                String description,
                                Double payment,
                                int min_age,
                                String attire) {}
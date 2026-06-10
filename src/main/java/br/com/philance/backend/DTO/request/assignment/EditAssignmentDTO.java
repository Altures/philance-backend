package br.com.philance.backend.DTO.request.assignment;

public record EditAssignmentDTO(Long id_address,
                                String description,
                                Double payment,
                                int min_age,
                                String attire) {}
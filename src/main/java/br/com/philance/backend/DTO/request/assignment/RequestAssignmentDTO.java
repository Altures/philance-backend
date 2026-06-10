package br.com.philance.backend.DTO.request.assignment;

public record RequestAssignmentDTO(Long id_company,
                                   Long id_address,
                                   String title,
                                   String description,
                                   Double payment,
                                   int min_age,
                                   String attire) {}
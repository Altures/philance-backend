package br.com.philance.backend.DTO.request.assignment;

public record RequestAssignmentDTO(String id_company,
                                   String id_address,
                                   String title,
                                   String description,
                                   Float payment,
                                   int min_age,
                                   String attire) {}
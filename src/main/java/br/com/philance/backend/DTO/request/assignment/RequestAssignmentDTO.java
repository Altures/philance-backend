package br.com.philance.backend.DTO.request.assignment;

public record RequestAssignmentDTO(String id_company,
                                   String id_address,
                                   String title,
                                   String description,
                                   Float payment,
                                   int min_age,
                                   String attire,
                                   //atualização 04/08/2026
                                   String id_tag,
                                   String start_hour,
                                   String finish_hour
                                   ) {}
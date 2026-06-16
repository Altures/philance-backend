package br.com.philance.backend.DTO.request.rating;

public record PublishReviewDTO(String id_assignment,
                               String id_author,
                               String id_target,
                               Integer review,
                               String comments){}
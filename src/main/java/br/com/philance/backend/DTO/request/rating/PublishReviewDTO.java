package br.com.philance.backend.DTO.request.rating;

public record PublishReviewDTO(Long id_assignment,
                               Long id_author,
                               Long id_subject,
                               int review,
                               String comments){}
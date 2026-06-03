package br.com.philance.backend.DTO;

public record PublishReviewDTO(Long id_assignment,
                               Long id_author,
                               Long id_subject,
                               int review,
                               String comments){
}
package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.rating.PublishReviewDTO;
import br.com.philance.backend.model.Rating;
import jakarta.validation.Valid;
import br.com.philance.backend.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/ratings")
    public Rating PublishReview(@Valid @RequestBody PublishReviewDTO dto){
        return ratingService.publishReview(dto.id_assignment(), dto.id_author(), dto.id_target(), dto.review(), dto.comments());
    }
}
package br.com.philance.backend.DTO.response.assignment;

import br.com.philance.backend.model.Assignment;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record AssignmentInfosDTO(
        String title,
        String company,
        String address,
        String description,
        Float payment,
        Integer min_age,
        String attire,
        LocalDateTime startHour,
        LocalDateTime finishHour
) {
    public AssignmentInfosDTO(Assignment assignment){
        this(
                assignment.getTitle(),
                assignment.getCompany() !=null?assignment.getCompany().getUsername(): null,
                assignment.getAddress() !=null? assignment.getAddress().getCity(): null,
                assignment.getDescription(),
                assignment.getPayment(),
                assignment.getMin_age(),
                assignment.getAttire(),
                assignment.getStartHour(),
                assignment.getFinishHour()
            );
    }
}

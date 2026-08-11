package br.com.philance.backend.DTO.response.assignment;

import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.AssignmentStatus;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record AssignmentInfosDTO(
        String id,
        String title,
        String company,
        String address,
        String description,
        Float payment,
        Integer min_age,
        String attire,
        LocalDateTime startHour,
        LocalDateTime finishHour,
        AssignmentStatus status
) {
    public AssignmentInfosDTO(Assignment assignment){
        this(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getCompany() !=null?assignment.getCompany().getUsername(): null,
                assignment.getAddress() !=null? assignment.getAddress().getCity(): null,
                assignment.getDescription(),
                assignment.getPayment(),
                assignment.getMin_age(),
                assignment.getAttire(),
                assignment.getStart_hour(),
                assignment.getFinish_hour(),
                assignment.getStatus()
            );
    }
}

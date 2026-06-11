package br.com.philance.backend.DTO.response.assignment;

import br.com.philance.backend.model.Assignment;

public record AssignmentInfosDTO(
        String title,
        String company,
        String address,
        String description,
        Double payment,
        Integer min_age,
        String attire
) {
    public AssignmentInfosDTO(Assignment assignment){
        this(
                assignment.getTitle(),
                assignment.getCompany() !=null?assignment.getCompany().getUsername(): null,
                assignment.getAddress() !=null? assignment.getAddress().getCity(): null,
                assignment.getDescription(),
                assignment.getPayment(),
                assignment.getMin_age(),
                assignment.getAttire()
            );
    }
}

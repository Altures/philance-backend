package br.com.philance.backend.DTO.response;

import br.com.philance.backend.model.Assignment;

public record AssignmentForLibraryDTO(
        String title,
        String company,
        String address,
        String description,
        Double payment,
        int min_age,
        String attire
) {
    public AssignmentForLibraryDTO (Assignment assignment){
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

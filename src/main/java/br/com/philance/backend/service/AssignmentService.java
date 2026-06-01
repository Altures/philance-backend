package br.com.philance.backend.service;

import br.com.philance.backend.Repository.AddressRepository;
import br.com.philance.backend.Repository.AssignmentRepository;
import br.com.philance.backend.Repository.UserRepository;
import br.com.philance.backend.model.Address;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    @Transactional
    public Assignment requestAssignment(Long id_company,
                                        Long id_address,
                                        String title,
                                        String description,
                                        Double payment,
                                        int min_age,
                                        String attire){
        //Aqui far-se-á conferencias, etc
        Assignment newAssignment = new Assignment();

        User company = userRepository.findById(id_company)
                .orElseThrow(() -> new RuntimeException("Company not found!"));
        Address address = addressRepository.findById(id_address)
                .orElseThrow(() -> new RuntimeException("Address not found!"));

        newAssignment.setCompany(company);
        newAssignment.setAddress(address);
        newAssignment.setTitle(title);
        newAssignment.setDescription(description);
        newAssignment.setPayment(payment);
        newAssignment.setMin_age(min_age);
        newAssignment.setAttire(attire);

        return assignmentRepository.save(newAssignment);
    }
}

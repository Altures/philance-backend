package br.com.philance.backend.service;

import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.repository.AddressRepository;
import br.com.philance.backend.repository.AssignmentRepository;
import br.com.philance.backend.repository.UserRepository;
import br.com.philance.backend.model.Address;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    @Transactional
    public Assignment requestAssignment(String id_company,
                                        String id_address,
                                        String title,
                                        String description,
                                        Float payment,
                                        int min_age,
                                        String attire){

        User company = userRepository.findById(id_company)
                .orElseThrow(() -> new RuntimeException("Company not found!"));
        Address address = addressRepository.findById(id_address)
                .orElseThrow(() -> new RuntimeException("Address not found!"));

        Assignment newAssignment = new Assignment();

        newAssignment.setCompany(company);
        newAssignment.setAddress(address);
        newAssignment.setTitle(title);
        newAssignment.setDescription(description);
        newAssignment.setPayment(payment);
        newAssignment.setMin_age(min_age);
        newAssignment.setAttire(attire);

        return assignmentRepository.save(newAssignment);
    }

    public Page<AssignmentInfosDTO> loadAssigmentsPaged(Pageable pageable){
        Page<Assignment> assignments =  assignmentRepository.findAll(pageable);

        return assignments.map(AssignmentInfosDTO::new);
    }

    public AssignmentInfosDTO findRandomAssignment(){
        Assignment assignment= assignmentRepository.findRandomAssignment()
                .orElseThrow(()-> new RuntimeException("No assginments found"));
        return new AssignmentInfosDTO(assignment);
    }

    public List<AssignmentInfosDTO> listAssingmentsInProgress(String id_user){
        return assignmentRepository.listAssignmentsByID(id_user);
    }

    public MessageDTO finishAssignment(String id_assignment){
        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(()-> new RuntimeException("Assignment not found"));
        User freelancer = assignment.getFreelancer();
        User company = assignment.getCompany();

        assignment.setStatus("Completed");
        assignment.setConclusion(LocalDateTime.now());
        company.setServices_count(company.getServices_count()+1);
        freelancer.setServices_count(freelancer.getServices_count()+1);
        
        userRepository.save(freelancer);
        userRepository.save(company);
        assignmentRepository.save(assignment);

        return new MessageDTO("Assignment completed!","Added 1 in assignment count of company and freelancer|Assignment status");

    }
}

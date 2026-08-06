package br.com.philance.backend.service;

import br.com.philance.backend.DTO.request.assignment.FilterDTO;
import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.model.Tag;
import br.com.philance.backend.repository.AddressRepository;
import br.com.philance.backend.repository.AssignmentRepository;
import br.com.philance.backend.repository.TagRepository;
import br.com.philance.backend.repository.UserRepository;
import br.com.philance.backend.model.Address;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.User;
import br.com.philance.backend.specification.AssignmentSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public Assignment requestAssignment(String id_company,
                                        String id_address,
                                        String title,
                                        String description,
                                        Float payment,
                                        int min_age,
                                        String attire,
                                        String id_tag,
                                        String start_hour,
                                        String finish_hour
                                        ){

        User company = userRepository.findById(id_company)
                .orElseThrow(() -> new RuntimeException("Company not found!"));
        Address address = addressRepository.findById(id_address)
                .orElseThrow(() -> new RuntimeException("Address not found!"));
        Tag tag = tagRepository.findById(id_tag)
                .orElseThrow(()-> new RuntimeException("Tag not found!"));

        LocalDateTime start_hour_localdatatime = LocalDateTime.parse(start_hour);
        LocalDateTime finish_hour_localdatatime = LocalDateTime.parse(finish_hour);

        Assignment newAssignment = new Assignment();

        newAssignment.setCompany(company);
        newAssignment.setAddress(address);
        newAssignment.setTitle(title);
        newAssignment.setDescription(description);
        newAssignment.setPayment(payment);
        newAssignment.setMin_age(min_age);
        newAssignment.setAttire(attire);
        newAssignment.setTag(tag);
        newAssignment.setStart_hour(start_hour_localdatatime);
        newAssignment.setFinish_hour(finish_hour_localdatatime);

        return assignmentRepository.save(newAssignment);
    }

    public Page<AssignmentInfosDTO> loadAssigmentsPaged(FilterDTO filters, Pageable pageable){
        Specification<Assignment> spec = AssignmentSpecification.filtered(filters);

        Page<Assignment> assignments =  assignmentRepository.findAll(spec,pageable);

        return assignments.map(AssignmentInfosDTO::new);
    }

    public AssignmentInfosDTO findRandomAssignment(){
        Assignment assignment= assignmentRepository.findRandomAssignment()
                .orElseThrow(()-> new RuntimeException("No assginments found"));
        return new AssignmentInfosDTO(assignment);
    }

    public List<AssignmentInfosDTO> listAssingmentsInProgress(String id_user){

        List<Assignment> assignments = assignmentRepository.findByFreelancerId(id_user);

        return assignments.stream()
                .map(a -> new AssignmentInfosDTO(
                        a.getId(),
                        a.getTitle(),
                        a.getCompany().getId(),     // Certifique-se de que a sua record aceita o tipo Entity aqui
                        a.getAddress().getId(),     // Certifique-se de que a sua record aceita o tipo Entity aqui
                        a.getDescription(),
                        a.getPayment(),
                        a.getMin_age(),
                        a.getAttire(),
                        a.getStart_hour(),
                        a.getFinish_hour()
                )).toList();
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

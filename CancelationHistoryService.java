package br.com.philance.backend.service;

import br.com.philance.backend.Repository.AssignmentRepository;
import br.com.philance.backend.Repository.CancelationHistoryRepository;
import br.com.philance.backend.Repository.UserRepository;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.model.CancelationHistory;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelationHistoryService {
    @Autowired
    private CancelationHistoryRepository cancelationHistoryRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public CancelationHistory cancel(Long id_assignment,
                                     Long id_user,
                                     String reason){

        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));

        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (user.getType() == 'C'){ // Empresa: status = 'Canceled'
            assignment.setStatus("Canceled");
        } else if (user.getType() == 'F') { // Freelancer: status = 'Pending'
            assignment.setStatus("Pending");
            assignment.setFreelancer(null); //Remove o freelancer da vaga
        }
        //Salva a alteração do status
        assignmentRepository.save(assignment);
        //Cria e salva o registro
        CancelationHistory newCancel = new CancelationHistory();

        newCancel.setAssignment(assignment);
        newCancel.setUser(user);
        newCancel.setReason(reason);

        return cancelationHistoryRepository.save(newCancel);
    }
}
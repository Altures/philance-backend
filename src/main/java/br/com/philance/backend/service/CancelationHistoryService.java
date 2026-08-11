package br.com.philance.backend.service;

import br.com.philance.backend.model.AssignmentStatus;
import br.com.philance.backend.repository.AssignmentRepository;
import br.com.philance.backend.repository.CancelationHistoryRepository;
import br.com.philance.backend.repository.UserRepository;
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
    public CancelationHistory cancel(String id_assignment,
                                     String id_user,
                                     String reason){

        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));

        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (user.getType() == 'C'){ // Empresa: status = 'Canceled'
            assignment.setStatus(AssignmentStatus.CANCELED);
        } else if (user.getType() == 'F') { // Freelancer: status = 'Pending'
            assignment.setStatus(AssignmentStatus.PENDING);
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
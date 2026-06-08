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
    private AssignmentRepository assignmentRepository;
    private UserRepository userRepository;

    @Transactional
    public CancelationHistory cancel(Long id_assignment,
                                     Long id_user,
                                     String reason){
        CancelationHistory newCancel = new CancelationHistory();

        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));

        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        newCancel.setAssignment(assignment);
        newCancel.setUser(user);
        newCancel.setReason(reason);

        return cancelationHistoryRepository.save(newCancel);
    }
}
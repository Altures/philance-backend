package br.com.philance.backend.service;

import br.com.philance.backend.Repository.AssignmentRepository;
import br.com.philance.backend.model.Assignment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional
    public Assignment requestAssignment(Assignment newAssignment){
        //Aqui far-se-á conferencias, etc
        return assignmentRepository.save(newAssignment);
    }
}

package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.assignment.RequestAssignmentDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/request-assignment")
    public Assignment requestAssignment(@RequestBody RequestAssignmentDTO dto){
        return assignmentService.requestAssignment(dto.id_company(), dto.id_address(), dto.title(), dto.description(), dto.payment(), dto.min_age(), dto.attire());
    }

    @GetMapping("/finish-assignment/{id_assignment}")
    public MessageDTO finishAssignment(@PathVariable String id_assignment){
        return assignmentService.finishAssignment(id_assignment);
    }
}
package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.RequestAssignmentDTO;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/assignments")
    public Assignment requestAssignment(@RequestBody RequestAssignmentDTO dto){
        return assignmentService.requestAssignment(dto.id_company(), dto.id_address(), dto.title(), dto.description(), dto.payment(), dto.min_age(), dto.attire());
    }


}

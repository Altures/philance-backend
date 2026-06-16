package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.user.LoginDTO;
import br.com.philance.backend.DTO.request.user.RegisterNewUserDTO;
import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.DTO.response.user.AcceptAssignmentDTO;
import br.com.philance.backend.DTO.response.user.LoginInfoResponseDTO;
import br.com.philance.backend.model.User;
import br.com.philance.backend.service.AssignmentService;
import br.com.philance.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register-user")
    public User registerUser(@RequestBody RegisterNewUserDTO dto){
        return userService.registerUser(dto.username(), dto.email(), dto.phone(), dto.birthday(), dto.type(), dto.password(), dto.document());
    }

    @PostMapping("/login-user")
    public LoginInfoResponseDTO loginUser(@RequestBody LoginDTO dto){
        return userService.loginInfoRequest(dto.email(), dto.password());
    }

    @PostMapping("/accept-assignment")
    public MessageDTO acceptAssignmet(@RequestBody AcceptAssignmentDTO dto){
        return userService.AcceptAssignment(dto.id_user(), dto.id_assignment());
    }

    @GetMapping("/assingments-in-progress/{id_user}")
    public List<AssignmentInfosDTO> assignmentsInProgress(@PathVariable String id_user){
        return assignmentService.listAssingmentsInProgress(id_user);
    }
}
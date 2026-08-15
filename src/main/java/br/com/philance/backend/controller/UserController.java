package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.user.EditProfileDTO;
import br.com.philance.backend.DTO.request.user.LoginDTO;
import br.com.philance.backend.DTO.request.user.RegisterNewUserDTO;
import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.DTO.response.user.AcceptAssignmentDTO;
import br.com.philance.backend.DTO.response.user.LoginInfoResponseDTO;
import br.com.philance.backend.DTO.response.user.UserInfosDTO;
import br.com.philance.backend.model.User;
import br.com.philance.backend.service.AssignmentService;
import br.com.philance.backend.service.UserService;
import jakarta.validation.Valid;
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
    public LoginInfoResponseDTO registerUser(@Valid @RequestBody RegisterNewUserDTO dto){
        return userService.registerUser(dto.username(), dto.email(), dto.phone(), dto.birthday(), dto.type(), dto.description(), dto.password(), dto.document(), dto.zip_code(), dto.street(), dto.number(), dto.complement(), dto.neighborhood(), dto.city(), dto.state());
    }

    @PostMapping("/edit-profile")
    public UserInfosDTO editProfile(@Valid @RequestBody EditProfileDTO dto){
        return userService.editProfile(dto.id_user(), dto.username(), dto.email(), dto.phone(), dto.description(), dto.password(), dto.zip_code(), dto.street(), dto.number(), dto.complement(), dto.neighborhood(), dto.city(), dto.state());
    }

    @PostMapping("/login-user")
    public LoginInfoResponseDTO loginUser(@Valid @RequestBody LoginDTO dto){
        return userService.loginInfoRequest(dto.email(), dto.password());
    }

    @PostMapping("/accept-assignment")
    public MessageDTO acceptAssignmet(@Valid @RequestBody AcceptAssignmentDTO dto){
        return userService.AcceptAssignment(dto.id_user(), dto.id_assignment());
    }

    @GetMapping("/assingments-in-progress-f/{id_user}")
    public List<AssignmentInfosDTO> assignmentsInProgressF(@PathVariable String id_user){
        return assignmentService.listAssingmentsInProgressF(id_user);
    }
    @GetMapping("/assignments-in-progress-c/{id_user}")
    public List<AssignmentInfosDTO> assignmentsInRequestC(@PathVariable String id_user){
        return assignmentService.listAssignmentsInRequestC(id_user);
    }

    @GetMapping("/assingments-finished/{id_user}")
    public List<AssignmentInfosDTO> assignmentsFinished(@PathVariable String id_user){
        return assignmentService.listAssingmentsFinished(id_user);
    }

    @PostMapping("/delete-account")
    public MessageDTO deleteAccount(@Valid @RequestBody String id_user){
        return userService.deleteAccount(id_user);
    }
}
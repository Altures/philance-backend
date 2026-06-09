package br.com.philance.backend.controller;

import br.com.philance.backend.DTO.request.RegisterNewUserDTO;
import br.com.philance.backend.model.User;
import br.com.philance.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    public User registerUser(@RequestBody RegisterNewUserDTO dto){
        return userService.registerUser(dto.username(), dto.email(), dto.phone(), dto.birthday(), dto.type(), dto.password(), dto.document());
    }
}
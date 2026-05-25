package br.com.philance.backend.controller;

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

    @PostMapping("/user")
    public User registerUser(@RequestBody User newUser){
        return userService.registerUser(newUser);
    }
}

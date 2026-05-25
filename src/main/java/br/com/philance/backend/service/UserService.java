package br.com.philance.backend.service;

import br.com.philance.backend.Repository.UserRepository;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User registerUser(User newUser){

        return userRepository.save(newUser);
    }
}

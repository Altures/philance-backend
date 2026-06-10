package br.com.philance.backend.service;

import br.com.philance.backend.DTO.response.user.LoginInfoRequestDTO;
import br.com.philance.backend.Repository.UserRepository;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User registerUser(String username,
                             String email,
                             String phone,
                             String birthday,
                             char type,
                             String password,
                             String document
    ){
        LocalDate birthdayConverted = LocalDate.parse(birthday);

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthday(birthdayConverted);
        user.setType(type);
        user.setPassword(password);
        user.setDocument(document);

        return userRepository.save(user);
    }

    public LoginInfoRequestDTO loginInfoRequest(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));
        String userPassword = user.getPassword();
        if(!Objects.equals(userPassword, password)){
            throw new RuntimeException("Invalid password");
        }else{
            return new LoginInfoRequestDTO(user);
        }
    }
}

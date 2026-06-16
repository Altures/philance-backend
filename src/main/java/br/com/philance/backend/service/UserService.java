package br.com.philance.backend.service;

import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.DTO.response.user.LoginInfoResponseDTO;
import br.com.philance.backend.repository.AssignmentRepository;
import br.com.philance.backend.repository.UserRepository;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional
    public User registerUser(String username,
                             String email,
                             String phone,
                             String birthday,
                             Character type,
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

    public LoginInfoResponseDTO loginInfoRequest(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));
        String userPassword = user.getPassword();
        if(!Objects.equals(userPassword, password)){
            throw new RuntimeException("Invalid password");
        }else{
            return new LoginInfoResponseDTO(user);
        }
    }

    public MessageDTO AcceptAssignment( String id_user, String id_assignment) {
        User user = userRepository.findById(id_user)
                .orElseThrow(()->new RuntimeException("User not found"));
        Assignment assignment = assignmentRepository.findById(id_assignment)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        if (assignment.getStatus() != "Pending"){return new MessageDTO("Accept Error!","Assignment already accepted");}

        //Conferência se já não possui um serviço na mesma hora
        //Conferência de frequencia de serviços aceitos

        assignment.setFreelancer(user);
        assignment.setStatus("In Progress");

        assignmentRepository.save(assignment);

        return new MessageDTO("Assignment Accepted!", "");
    }
}

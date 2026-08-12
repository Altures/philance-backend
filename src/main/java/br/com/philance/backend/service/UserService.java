package br.com.philance.backend.service;

import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.DTO.response.user.LoginInfoResponseDTO;
import br.com.philance.backend.model.Address;
import br.com.philance.backend.model.Assignment;
import br.com.philance.backend.DTO.response.general.MessageDTO;
import br.com.philance.backend.DTO.response.user.UserInfosDTO;
import br.com.philance.backend.model.AssignmentStatus;
import br.com.philance.backend.repository.AddressRepository;
import br.com.philance.backend.repository.AssignmentRepository;
import br.com.philance.backend.repository.UserRepository;
import br.com.philance.backend.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public LoginInfoResponseDTO registerUser(String username,
                                             String email,
                                             String phone,
                                             String birthday,
                                             Character type,
                                             String password,
                                             String document,
                                             String zip_code,
                                             String street,
                                             String number,
                                             String complement,
                                             String neighborhood,
                                             String city,
                                             String state
    ){
        LocalDate birthdayConverted = LocalDate.parse(birthday);

        if (userRepository.existsByEmail(email)) {
            return null;//new MessageDTO("Email already in use","This email is already registerd");
        }
        if (userRepository.existsByPhone(phone)) {
            return null;//new MessageDTO("phone already in use","This phone is already registerd");
        }
        if (userRepository.existsByDocument(document)){
            return null;//new MessageDTO("document already in use","This document is already registerd");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthday(birthdayConverted);
        user.setType(type);
        user.setPassword(password);
        user.setDocument(document);



        Address newAddress = new Address();

        newAddress.setZipCode(zip_code);
        newAddress.setStreet(street);
        newAddress.setNumber(number);
        newAddress.setComplement(complement);
        newAddress.setNeighborhood(neighborhood);
        newAddress.setCity(city);
        newAddress.setState(state);

        if (!addressRepository.existsByZipCodeAndStreetAndNumberAndComplementAndNeighborhoodAndCityAndState(zip_code, street, number, complement, neighborhood, city, state)){
            addressRepository.save(newAddress);
        }
        user.setAddress(newAddress);

        userRepository.save(user);
        return new LoginInfoResponseDTO(user);
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

        if (!Objects.equals(assignment.getStatus(), AssignmentStatus.PENDING)){return new MessageDTO("Accept Error!","Assignment already accepted");}

        LocalDateTime startHour = assignment.getStart_hour();

        List<AssignmentInfosDTO> assignmentsUser = assignmentService.listAssingmentsInProgressF(id_user);
        for (AssignmentInfosDTO assignmentInfosDTO : assignmentsUser) {
            if (startHour.isAfter(assignmentInfosDTO.startHour()) && startHour.isBefore(assignmentInfosDTO.finishHour())) {
                return new MessageDTO("Accept Error!", "Already have assignment in the same time:" + assignmentInfosDTO);
            }
        }
        
        //Conferência de frequencia de serviços aceitos

        assignment.setFreelancer(user);
        assignment.setStatus(AssignmentStatus.ACCEPTED);

        assignmentRepository.save(assignment);

        return new MessageDTO("Assignment Accepted!", "");
    }

    public MessageDTO deleteAccount(String id_user){
        User user = userRepository.findById(id_user)
                .orElseThrow(()->new RuntimeException("User not found"));

        userRepository.delete(user);
        return new MessageDTO("Account Deleted!","Success");
    }

    public UserInfosDTO editProfile(String id_user,String username, String phone, LocalDate birthday, String descrption){
        User user = userRepository.findById(id_user)
                .orElseThrow(()-> new RuntimeException("User not found!"));

        user.setUsername(username);
        user.setPhone(phone);
        user.setBirthday(birthday);
        user.setDescription(descrption);

        userRepository.save(user);
        return new UserInfosDTO(user);
    }
}

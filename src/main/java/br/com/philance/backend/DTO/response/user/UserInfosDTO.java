package br.com.philance.backend.DTO.response.user;

import br.com.philance.backend.model.User;

import java.time.format.DateTimeFormatter;

public record UserInfosDTO(
        String id_user,
        String username,
        String email,
        String address,
        String phone,
        String birthday,
        String document,
        char type,
        float average_rating,
        String description,
        int services_count
) {

    public UserInfosDTO(User user){

        this(
                user.getId_user(),
                user.getUsername(),
                user.getEmail(),
                user.getAddress() !=null? user.getAddress().getCity():null,
                user.getPhone(),
                user.getBirthday() !=null? user.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):null,
                user.getDocument(),
                user.getType(),
                user.getAverage_rating(),
                user.getDescription(),
                user.getServices_count()
        );
    }
}

package br.com.philance.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor // Cria o construtor padrão obrigatório
@AllArgsConstructor // Cria o construtor com todos os atributos

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_user;
    private String username;
    private String email;
    private String password;
    private String document;
    private float average_rating;
    private String description;
    private int services_count;
}
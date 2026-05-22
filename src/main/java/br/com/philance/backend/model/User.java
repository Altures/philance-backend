package br.com.philance.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// ADICIONE ESSAS TRÊS LINHAS ABAIXO:
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // Cria o construtor padrão obrigatório
@AllArgsConstructor // Cria o construtor com todos os atributos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String username;
    private String email;
    private String password;
    private String document;
    private float average_rating;
    private String description;
    private int services_count;
    private LocalDate  created_at;
    private LocalDateTime modified_at;
}
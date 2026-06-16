package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor // Cria o construtor padrão obrigatório
@AllArgsConstructor // Cria o construtor com todos os atributos

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    public String id_user;
    @Column(name = "username", nullable = false, length = 120)
    private String username;
    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;
    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @OneToMany
    @JoinColumn(name = "id_address") // Relacionamento com o Endereço (Tabela Address)
    private Address address;

    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
    @Column(name = "document", nullable = false, unique = true, length = 14)
    private String document;
    @Column(name = "type", nullable = false, length = 1)
    private Character type;
    @Column(name = "average_rating")
    private Float average_rating = 5F;
    @Column(name = "description")
    private String description;
    @Column(name = "services_count")
    private Integer services_count = 0;
}
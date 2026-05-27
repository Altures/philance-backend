package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor // Cria o construtor padrão obrigatório
@AllArgsConstructor // Cria o construtor com todos os atributos

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public Long id_user;
    @Column(name = "username", nullable = false, length = 120)
    private String username;
    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;
    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @OneToOne // verificar
    @JoinColumn(name = "id_address") // Relacionamento com o Endereço (Tabela Address)
    private Address address;

    @Column(name = "document", nullable = false, unique = true, length = 14)
    private String document;
    @Column(name = "type", nullable = false, length = 14)
    private char type;
    @Column(name = "average_rating")
    private float average_rating;
    @Column(name = "description")
    private String description;
    @Column(name = "services_count")
    private int services_count;
}
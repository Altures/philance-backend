package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "assignments")
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Assignment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assignment")
    private Long id_assignment;

    // Relacionamento com a Empresa (Tabela User)
    @ManyToOne // verificar
    @JoinColumn(name = "id_company", nullable = false)
    private User company;

    // Relacionamento com o Freelancer (Tabela User)
    @ManyToOne // verificar
    @JoinColumn(name = "id_freelancer")
    private User freelancer;

    // Relacionamento com o Endereço (Tabela Address)
    @ManyToOne // verificar
    @JoinColumn(name = "id_address", nullable = false)
    private Address address;

    @Column(name = "title", length = 120, nullable = false)
    private String title;
    @Column(name = "status", length = 20, nullable = false)
    String status = "Pendente";
    @Column(name = "description", length = 255, nullable = false)
    private String description;
    @Column(name = "payment")
    private Double payment;
    @Column(name = "min_age")
    private int min_age;
    @Column(name = "attire", length = 255)
    private String attire;
}
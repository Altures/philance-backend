package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

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
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;
    @Column(name = "description", length = 255, nullable = false)
    private String description;
    @Column(name = "payment")
    private Float payment;
    @Column(name = "min_age")
    private Integer min_age;
    @Column(name = "attire", length = 255)
    private String attire;
    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private Tag tag;
    @Column(name = "startHour", length = 20)
    private LocalDateTime startHour = null;
    @Column(name = "finishHour", length = 20)
    private LocalDateTime finishHour = null;
    @Column(name = "conclusion", length = 20)
    private LocalDateTime conclusion = null;
}


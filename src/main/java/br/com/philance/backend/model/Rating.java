package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "ratings")
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Rating extends BaseEntity { // Terminar, fazer tipo de avaliador ao invés de avaliador e avaliado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating")
    private Long id_rating;

    @OneToOne // verificar
    @JoinColumn(name = "id_assignment")
    private Assignment id_assignment;



}
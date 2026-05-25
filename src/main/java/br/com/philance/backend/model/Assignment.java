package br.com.philance.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Assignment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_assignment;
    private Long id_user;
    private String title;
    private boolean status;
    private String description;
    private Double payment;
    private LocalDateTime begin_at;
    private LocalDateTime end_at;
    private String adress;
    private int min_age;
    private String attire;
}

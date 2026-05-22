package br.com.philance.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;
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
    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    private LocalDate created_at;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

}

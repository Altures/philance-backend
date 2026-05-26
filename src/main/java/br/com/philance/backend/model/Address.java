package br.com.philance.backend.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id_address;
    @Column(name = "zip_code", nullable = false)
    private String zip_code;
    @Column(name = "street", length = 100, nullable = false)
    private String street;
    @Column(name = "number", length = 6, nullable = false)
    private String number;
    @Column(name = "complement", length = 50)
    private String complement;
    @Column(name = "neighborhood", length = 50, nullable = false)
    private String neighborhood;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "state", length = 2, nullable = false)
    private String state;
}

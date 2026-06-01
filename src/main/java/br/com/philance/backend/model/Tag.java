package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private int id_tag;
    @Column(name = "name_tag", nullable = false, length = 50)
    private String name_tag;
    @Column(name = "type", nullable = false, length = 1)
    private char type; // 'F' para Freelancer 'C' para Company
}
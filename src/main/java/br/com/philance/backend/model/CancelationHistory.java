package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "cancelations_history")
@NoArgsConstructor // Cria o construtor padrão obrigatório
@AllArgsConstructor // Cria o construtor com todos os atributos

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CancelationHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cancelation")
    private String id_cancelation;

    @OneToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "reason")
    private String reason;
}
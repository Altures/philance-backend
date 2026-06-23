package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ratings")
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Rating extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_rating")
    private String id_rating;

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    // Chave estrangeira para quem avalia
    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private User author;

    // Chave estrangeira para quem é avaliado
    @ManyToOne
    @JoinColumn(name = "id_target", nullable = false)
    private User target;

    @Column(name = "review")
    private Integer review;
    @Column(name = "comments", length = 255)
    private String comments;
}
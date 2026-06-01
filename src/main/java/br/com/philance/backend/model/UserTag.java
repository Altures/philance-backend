package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "user_tags")
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserTag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_tag;

    @ManyToOne
    @JoinColumn(name="id_user", nullable = false)
    private User id_user;

    @ManyToOne
    @JoinColumn(name="id_tag", nullable = false)
    private Tag id_tag;
}
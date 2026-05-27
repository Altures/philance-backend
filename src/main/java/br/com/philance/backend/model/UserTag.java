package br.com.philance.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserTag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_tag;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User id_user;

    @ManyToOne
    @JoinColumn(name="tag_id", nullable = false)
    private Tag id_tag;
}

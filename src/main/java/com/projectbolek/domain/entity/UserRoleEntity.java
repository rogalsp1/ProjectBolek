package com.projectbolek.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectbolek.domain.model.enums.UserRoleEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "user_roles", schema = "bolekshema")
@Data
public class UserRoleEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 3452827120686907942L;

    @Id @SequenceGenerator(name = "user_roles_id_seq", sequenceName = "bolekshema.user_roles_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_roles_id_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

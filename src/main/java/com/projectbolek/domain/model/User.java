package com.projectbolek.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "system_user", schema = "bolekshema")
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -4084090776711803189L;

    @Id @SequenceGenerator(name = "user_id_seq", sequenceName = "bolekshema.system_user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;

    private String username;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Visit> visitList;

    @JsonIgnore
    @OneToMany(mappedBy = "personel")
    private List<PersonelInaccessibility> inaccessibility;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<UserRole> roles;


}

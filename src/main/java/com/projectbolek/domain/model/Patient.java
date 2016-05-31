package com.projectbolek.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "patient", schema = "bolekshema")
@Data
public class Patient implements Serializable{

    private static final long serialVersionUID = -4132255923600636185L;

    @Id @SequenceGenerator(name = "patient_id_seq", sequenceName = "patient_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    private Boolean active;

    private String pesel;

    private Timestamp birthdate;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @JsonIgnore
    @OneToOne(mappedBy = "patient")
    private ContactDetails contactDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Charge> charges;
}

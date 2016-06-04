package com.projectbolek.domain.entity;

import com.projectbolek.domain.model.enums.SexEnum;
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
public class PatientEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -4132255923600636185L;

    @Id @SequenceGenerator(name = "patient_id_seq", sequenceName = "bolekshema.patient_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private Boolean active;

    private String pesel;

    private Timestamp birthdate;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @OneToOne(mappedBy = "patient")
    private ContactDetailsEntity contactDetailsEntity;

    @OneToMany(mappedBy = "patient")
    private List<ChargeEntity> charges;
}

package com.projectbolek.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "contact_details", schema = "bolekshema")
@Data
@JsonNaming
public class ContactDetails implements Serializable {

    private static final long serialVersionUID = 5140439178383171952L;

    @Id @SequenceGenerator(name = "contact_detils_id_seq", sequenceName = "contact_detils_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_detils_id_seq")
    private Long id;

    private String country;

    private String province;

    private String city;

    private String street;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}

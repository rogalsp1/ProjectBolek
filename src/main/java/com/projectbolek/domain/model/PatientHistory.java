package com.projectbolek.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "patient_history")
@Data
public class PatientHistory implements Serializable {

    private static final long serialVersionUID = -8559689476521287120L;

    @Id @SequenceGenerator(name = "patient_history_id_seq", sequenceName = "patient_history_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_history_id_seq")
    private Long id;

    private Timestamp date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}

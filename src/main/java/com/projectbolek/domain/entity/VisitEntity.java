package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "visit", schema = "bolekshema")
@Data
public class VisitEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6721721413383160912L;

    @Id @SequenceGenerator(name = "visit_id_seq", sequenceName = "bolekshema.visit_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_id_seq")
    private Long id;

    private String notes;

    @Column(name = "visit_date")
    private Timestamp visitDate;

    @OneToMany(mappedBy = "visit")
    private List<ExaminationEntity> visitServiceList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
}

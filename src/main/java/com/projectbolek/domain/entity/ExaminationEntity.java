package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "examination", schema = "bolekshema")
@Data
public class ExaminationEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -1840984634913894104L;

    @Id @SequenceGenerator(name = "visit_service_id_seq", sequenceName = "bolekshema.visit_service_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_service_id_seq")
    private Long id;

    @Column(name = "service_date")
    private Timestamp serviceDate;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private VisitEntity visit;

}

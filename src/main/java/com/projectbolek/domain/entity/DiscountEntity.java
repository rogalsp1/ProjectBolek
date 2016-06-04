package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "discount", schema = "bolekshema")
@Data
public class DiscountEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2984387307223388047L;

    @Id @SequenceGenerator(name = "discount_id_seq", schema ="bolekshema.discount_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    private Long id;

    private Double discount;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "patiend_id")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}

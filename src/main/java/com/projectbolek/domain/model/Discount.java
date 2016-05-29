package com.projectbolek.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Data
public class Discount implements Serializable {

    private static final long serialVersionUID = 2984387307223388047L;

    @Id @SequenceGenerator(sequenceName = "discount_id_seq", name ="discount_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    private Long id;

    private Double discount;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "patiend_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}

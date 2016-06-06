package com.projectbolek.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Entity
@Table(schema = "bolekshema", name = "charge")
@Data
public class ChargeEntity extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 4225411281569337626L;

    @Id
    @SequenceGenerator(name = "charge_seq" ,sequenceName = "bolekshema.charge_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charge_seq")
    private Long id;

    @Column(name = "to_pay")
    private Double toPay;

    @Column(name = "service_date")
    private Timestamp invoiceDate;

    @Column(name = "payment_date")
    private Timestamp paymantDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @OneToOne
    @JoinColumn(name = "examination_id")
    private ExaminationEntity examination;


}

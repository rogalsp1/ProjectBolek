package com.projectbolek.domain.model;

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
public class Charge implements Serializable{

    private static final long serialVersionUID = 4225411281569337626L;

    @Id
    @SequenceGenerator(name = "charge_seq" ,sequenceName = "charge_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charge_seq")
    private Long id;

    @Column(name = "to_pay")
    private Long toPay;

    @Column(name = "invoice_date")
    private Timestamp invoiceDate;

    @Column(name = "payment_date")
    private Timestamp paymantDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "visit_service_id")
    private Charge charge;


}

package com.projectbolek.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Entity
@Table(name = "examination_result")
@Data
public class ExaminationResult implements Serializable {

    private static final long serialVersionUID = 1182064227024745058L;

    @Id @SequenceGenerator(name = "examination_result_id_seq", sequenceName = "examination_result_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examination_result_id_seq")
    private Long id;

    @Column
    private String fileName;

    @Lob
    private byte[] result;

    @ManyToOne
    @JoinColumn(name = "visit_service_id")
    private VisitService visitService;

}

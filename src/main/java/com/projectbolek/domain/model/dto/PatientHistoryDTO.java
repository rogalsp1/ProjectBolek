package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName("patient_history")
public class PatientHistoryDTO implements Serializable {

    private static final long serialVersionUID = 3049017085084771165L;

    private Long id;

    private Timestamp date;

    private String description;

    private Long patient;
}

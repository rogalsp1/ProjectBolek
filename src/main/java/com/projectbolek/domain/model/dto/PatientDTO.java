package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "patient")
public class PatientDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 8180159416374038080L;

    private Long id;

    private String firstName;

    private String lastName;

    private String sex;

    private Boolean active;

    private String pesel;

    private Timestamp birthdate;

    private Timestamp registrationDate;
}

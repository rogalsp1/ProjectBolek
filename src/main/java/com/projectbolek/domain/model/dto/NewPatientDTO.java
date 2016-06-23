package com.projectbolek.domain.model.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 23.06.16.
 */
@Data
public class NewPatientDTO {

    private String firstName;

    private String lastName;

    private String sex;

    private String pesel;

    private Timestamp birthdate;

    private String country;

    private String province;

    private String city;

    private String street;

    private String phoneNumber;
}

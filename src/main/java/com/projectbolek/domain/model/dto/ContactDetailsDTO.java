package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "contact_details")
public class ContactDetailsDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 3076104547041186277L;

    private Long id;

    private String country;

    private String province;

    private String city;

    private String street;

    private String phoneNumber;

    private Long patient;
}

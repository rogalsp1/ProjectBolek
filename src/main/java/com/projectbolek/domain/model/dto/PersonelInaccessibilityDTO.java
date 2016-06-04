package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName("personel_inaccessibility")
public class PersonelInaccessibilityDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = -1812282242585699434L;

    private Long id;

    private Timestamp startDate;

    private Timestamp endDate;

    private Long personel;
}

package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "examination")
public class ExaminationDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 9137593680995708334L;

    private Long id;

    private Timestamp serviceDate;

    private Long service;

    private Long visit;
}

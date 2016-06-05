package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName("visit")
public class VisitDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 2268325736475976758L;

    private Long id;

    private String notes;

    private Long personel;

    private Long patient;

    private String personelName;

    private String patientName;

    private Timestamp beginDateTime;

    private Timestamp endDateTime;
}

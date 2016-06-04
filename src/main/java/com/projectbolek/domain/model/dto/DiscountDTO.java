package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "discount")
public class DiscountDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = -2452477832891039526L;

    private Long id;

    private Double discount;

    private Timestamp startDate;

    private Timestamp endDate;

    private Long patient;

    private Long service;
}

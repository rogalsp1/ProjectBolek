package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "charge")
public class ChargeDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 6754736138806576446L;

    private Long id;

    private Long toPay;

    private Timestamp invoiceDate;

    private Timestamp paymantDate;

    private Long patient;

    private Long examination;
}

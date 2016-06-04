package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName(value = "examination_result")
public class ExaminationResultDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 7425603083349256389L;

    private Long id;

    private String fileName;

    private byte[] result;

    private Long examination;
}

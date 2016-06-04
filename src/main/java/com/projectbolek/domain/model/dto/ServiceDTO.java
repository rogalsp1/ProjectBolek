package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName("service")
public class ServiceDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = -8884894567770616134L;

    private Long id;

    private String serviceName;

    private String description;

    private Double price;
}

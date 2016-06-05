package com.projectbolek.domain.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@Data
public class PasswordDTO extends BaseDTO implements Serializable{
    private static final long serialVersionUID = -5616075725214219482L;

    private String password;
}

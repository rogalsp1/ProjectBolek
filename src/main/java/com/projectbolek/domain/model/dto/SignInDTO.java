package com.projectbolek.domain.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@Data
public class SignInDTO implements Serializable{

    private static final long serialVersionUID = 3027008023170759017L;

    private String username;

    private String password;
}

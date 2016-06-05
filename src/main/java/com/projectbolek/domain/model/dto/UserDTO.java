package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Data
@JsonRootName("user")
public class UserDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -9037955155633462428L;

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private Boolean admin;

    private Boolean doctor;

    private Boolean receptionist;
}

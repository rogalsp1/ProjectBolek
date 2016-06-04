package com.projectbolek.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.projectbolek.domain.model.enums.UserRoleEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    private List<UserRoleEnum> roles;
}

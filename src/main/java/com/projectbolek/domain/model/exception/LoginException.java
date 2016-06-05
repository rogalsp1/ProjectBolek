package com.projectbolek.domain.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Username or password incorrect")
public class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

package com.projectbolek.domain.model.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 01.06.16.
 */
@Slf4j
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends Exception implements Serializable{

    private static final long serialVersionUID = 4589302852429925483L;

    public ApplicationException(String message) {
        super(message);
    }
}

package com.nro.footballmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateResourceException extends Exception {

    public DuplicateResourceException(String message) {
        super(message);
    }
}

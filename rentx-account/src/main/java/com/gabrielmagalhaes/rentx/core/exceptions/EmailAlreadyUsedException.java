package com.gabrielmagalhaes.rentx.core.exceptions;

public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException(final String message) {
        super(message);
    }
}
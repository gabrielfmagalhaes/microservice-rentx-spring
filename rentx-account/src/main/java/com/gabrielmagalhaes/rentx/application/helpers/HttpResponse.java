package com.gabrielmagalhaes.rentx.application.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record HttpResponse(Object data) {
    public static ResponseEntity badRequest(Object data) {
        return new ResponseEntity(new HttpResponse(data), HttpStatus.BAD_REQUEST);
    }
}

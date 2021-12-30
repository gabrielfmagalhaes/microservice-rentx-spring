package com.gabrielmagalhaes.rentx.presenter.exceptions;

import com.gabrielmagalhaes.rentx.core.exceptions.EmailAlreadyUsedException;
import com.gabrielmagalhaes.rentx.data.ports.rest.out.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = {EmailAlreadyUsedException.class})
    ResponseEntity<ApiResponse> handleEmailAlreadyUsedException(EmailAlreadyUsedException ex) {
        return new ResponseEntity<>(new ApiResponse(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
    }
}

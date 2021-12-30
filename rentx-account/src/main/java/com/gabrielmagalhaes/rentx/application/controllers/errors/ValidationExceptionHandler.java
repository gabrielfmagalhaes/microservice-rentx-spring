package com.gabrielmagalhaes.rentx.application.controllers.errors;

import com.gabrielmagalhaes.rentx.application.helpers.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;


@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity> serverExceptionHandler(WebExchangeBindException e) {
        final String message = e.getFieldError().getField() + " " + e.getFieldError().getDefaultMessage();

        return Mono.just(HttpResponse.badRequest(message));
    }
}
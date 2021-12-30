package com.gabrielmagalhaes.rentx.application.controllers.impl;

import com.gabrielmagalhaes.rentx.application.controllers.SignUpController;
import com.gabrielmagalhaes.rentx.domain.contracts.gateways.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/signup")
public class SignUpControllerImpl implements SignUpController {

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> create(@Valid @RequestBody SignUpRequest request) {
        return Mono.just(null);
    }


}


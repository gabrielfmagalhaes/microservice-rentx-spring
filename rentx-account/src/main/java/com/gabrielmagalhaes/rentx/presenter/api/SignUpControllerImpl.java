package com.gabrielmagalhaes.rentx.presenter.api;

import com.gabrielmagalhaes.rentx.data.entities.SignUpRequest;
import com.gabrielmagalhaes.rentx.presenter.SignUpController;
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


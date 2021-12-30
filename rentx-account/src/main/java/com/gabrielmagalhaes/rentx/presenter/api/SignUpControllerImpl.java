package com.gabrielmagalhaes.rentx.presenter.api;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.entities.SignUpRequest;
import com.gabrielmagalhaes.rentx.presenter.SignUpController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignUpControllerImpl implements SignUpController {

    private final AddAccountUseCase useCase;

    public SignUpControllerImpl(AddAccountUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SignUpRequest request) {
        useCase.add(new Account());
    }


}


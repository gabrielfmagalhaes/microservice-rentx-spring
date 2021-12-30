package com.gabrielmagalhaes.rentx.presenter.api;

import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.entities.ApiResponse;
import com.gabrielmagalhaes.rentx.data.entities.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    private final AddAccountUseCase useCase;

    public SignUpController(AddAccountUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ApiResponse> create(@Valid @RequestBody SignUpRequest request) {
        useCase.add(SignUpRequest.toDomain(request));
        return Mono.just(new ApiResponse("account registered successfully", true));
    }


}


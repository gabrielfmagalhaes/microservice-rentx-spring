package com.gabrielmagalhaes.rentx.application.controllers;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.entities.SignUpRequest;
import com.gabrielmagalhaes.rentx.data.usecases.AddAccountUseCaseImpl;
import com.gabrielmagalhaes.rentx.presenter.SignUpController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@WebFluxTest(SignUpController.class)
public class SignUpControllerImplUnitSpec {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private AddAccountUseCase addAccountUseCase;

    @Test
    @DisplayName("should return 400 if email is empty")
    void shouldReturnBadRequestWhenMissingParamEmail() {
        SignUpRequest request = new SignUpRequest();

        webTestClient.post()
                .uri("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), SignUpRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @DisplayName("should return 201 if valid data is provided ")
    void shouldReturnCreatedWhenValidDataIsProvided() {
        SignUpRequest request = SignUpRequest.builder()
                .name("valid_name")
                .email("valid_email@email.com")
                .password("valid_password")
                .passwordConfirmation("valid_password")
                .admin(true)
                .build();

        BDDMockito.when(addAccountUseCase.add(any(Account.class))).thenReturn(null);

        webTestClient.post()
                .uri("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), SignUpRequest.class)
                .exchange()
                .expectStatus().isCreated();
    }
}

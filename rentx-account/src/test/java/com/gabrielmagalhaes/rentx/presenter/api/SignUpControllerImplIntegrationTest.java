package com.gabrielmagalhaes.rentx.presenter.api;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.exceptions.EmailAlreadyUsedException;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.ports.rest.in.SignUpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebFluxTest(SignUpController.class)
public class SignUpControllerImplIntegrationTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private AddAccountUseCase addAccountUseCase;

    @Test
    @DisplayName("should return 201 if valid data is provided")
    void shouldReturnCreatedWhenValidDataIsProvided() {
        SignUpRequest request = SignUpRequest.builder()
                .name("valid_name")
                .email("valid_email@email.com")
                .password("valid_password")
                .passwordConfirmation("valid_password")
                .admin(true)
                .build();

        when(addAccountUseCase.add(any(Account.class))).thenReturn(null);

        webTestClient.post()
                .uri("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), SignUpRequest.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    @DisplayName("should return 400 if email address is already in use")
    void shouldReturnExceptionWhenEmailAlreadyInUse() {
        SignUpRequest request = SignUpRequest.builder()
                .name("valid_name")
                .email("valid_email@email.com")
                .password("valid_password")
                .passwordConfirmation("valid_password")
                .admin(true)
                .build();

        when(addAccountUseCase.add(any(Account.class))).thenThrow(new EmailAlreadyUsedException("email address already in use"));

        webTestClient.post()
                .uri("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), SignUpRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }
}

package com.gabrielmagalhaes.rentx.application.controllers;

import com.gabrielmagalhaes.rentx.domain.contracts.gateways.SignUpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(SignUpController.class)
public class SignUpControllerImplUnitSpec {

    @Autowired
    WebTestClient webTestClient;

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
                .expectStatus().isBadRequest()
                .expectBody().jsonPath("$.data").isEqualTo("email must not be blank");
    }
}

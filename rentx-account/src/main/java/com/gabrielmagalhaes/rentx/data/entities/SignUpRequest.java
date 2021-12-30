package com.gabrielmagalhaes.rentx.data.entities;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.validation.constraint.FieldMatch;
import lombok.*;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@FieldMatch(first = "password", second = "passwordConfirmation", message = "password fields must match")
public class SignUpRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirmation;

    private boolean admin;

    public static Account toDomain(SignUpRequest request) {
        return new Account(request.name, request.email, request.password, request.admin);
    }
}

package com.gabrielmagalhaes.rentx.domain.contracts.gateways;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String email;
}

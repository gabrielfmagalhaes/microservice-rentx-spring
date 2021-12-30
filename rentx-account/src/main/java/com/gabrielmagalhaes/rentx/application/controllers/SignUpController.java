package com.gabrielmagalhaes.rentx.application.controllers;

import com.gabrielmagalhaes.rentx.domain.contracts.gateways.SignUpRequest;

public interface SignUpController {
    Object create(SignUpRequest request);
}

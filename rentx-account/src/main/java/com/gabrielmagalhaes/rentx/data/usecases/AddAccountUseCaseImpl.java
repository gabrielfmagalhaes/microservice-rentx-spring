package com.gabrielmagalhaes.rentx.data.usecases;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddAccountUseCaseImpl implements AddAccountUseCase {

    public Mono<Void> add(Account account) {
        return Mono.empty();
    }
}

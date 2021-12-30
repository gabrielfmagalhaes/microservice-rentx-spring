package com.gabrielmagalhaes.rentx.core.usecases;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import reactor.core.publisher.Mono;

public interface AddAccountUseCase {
    Mono<Account> add(Account account);
}

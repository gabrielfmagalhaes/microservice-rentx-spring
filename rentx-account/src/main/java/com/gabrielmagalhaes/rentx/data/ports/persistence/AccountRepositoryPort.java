package com.gabrielmagalhaes.rentx.data.ports.persistence;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import reactor.core.publisher.Mono;

public interface AccountRepositoryPort {
    Mono<Account> add(Account account);

    Mono<Account> findByEmail(String email);
}

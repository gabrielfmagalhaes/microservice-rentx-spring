package com.gabrielmagalhaes.rentx.data.ports.persistence.spi;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.infrastructure.postgres.entity.PostgresAccount;
import reactor.core.publisher.Mono;

public interface AccountRepositoryPort {
    Mono<Account> add(PostgresAccount account);

    Mono<Account> findByEmail(String email);
}

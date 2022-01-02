package com.gabrielmagalhaes.rentx.data.ports.persistence.entity;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.infrastructure.postgres.entity.PostgresAccount;
import reactor.core.publisher.Mono;

public class AccountAdapter {

    public static Mono<Account> toDomain(PostgresAccount postgresAccount) {
        return Mono.just(new Account(
                postgresAccount.getId(),
                postgresAccount.getName(),
                postgresAccount.getEmail(),
                postgresAccount.isAdmin()));
    }

    public static PostgresAccount toPostgres(Account account) {
        return PostgresAccount.builder()
                .name(account.getName())
                .email(account.getEmail())
                .password(account.getPassword())
                .admin(account.isAdmin())
                .build();
    }
}

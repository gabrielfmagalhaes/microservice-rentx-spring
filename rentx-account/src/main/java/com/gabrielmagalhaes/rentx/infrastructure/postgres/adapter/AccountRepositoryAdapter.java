package com.gabrielmagalhaes.rentx.infrastructure.postgres.adapter;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.data.ports.persistence.AccountRepositoryPort;
import com.gabrielmagalhaes.rentx.infrastructure.postgres.repository.AccountRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountRepository accountRepository;

    public AccountRepositoryAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Mono<Account> add(Account account) {
        return null;
    }

    @Override
    public Mono<Account> findByEmail(String email) {
        return null;
    }
}

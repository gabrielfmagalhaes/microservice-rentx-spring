package com.gabrielmagalhaes.rentx.infrastructure.postgres.adapter;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.data.ports.persistence.entity.AccountAdapter;
import com.gabrielmagalhaes.rentx.data.ports.persistence.spi.AccountRepositoryPort;
import com.gabrielmagalhaes.rentx.infrastructure.postgres.entity.PostgresAccount;
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
    public Mono<Account> add(PostgresAccount account) {
        return this.accountRepository.save(account).flatMap(AccountAdapter::toDomain);
    }

    @Override
    public Mono<Account> findByEmail(String email) {
        return null;
    }
}

package com.gabrielmagalhaes.rentx.data.usecases;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.exceptions.EmailAlreadyUsedException;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.ports.persistence.AccountRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddAccountUseCaseImpl implements AddAccountUseCase {

    private final AccountRepositoryPort repository;

    public AddAccountUseCaseImpl(AccountRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<Account> add(Account account) {
        Mono<Account> findAccount = repository.findByEmail(account.getEmail());

        if (findAccount != null) {
            throw new EmailAlreadyUsedException("email address already in use");
        }

        return repository.add(account);
    }
}

package com.gabrielmagalhaes.rentx.data.usecases;

import com.gabrielmagalhaes.rentx.core.domain.Account;
import com.gabrielmagalhaes.rentx.core.exceptions.EmailAlreadyUsedException;
import com.gabrielmagalhaes.rentx.core.usecases.AddAccountUseCase;
import com.gabrielmagalhaes.rentx.data.ports.persistence.entity.AccountAdapter;
import com.gabrielmagalhaes.rentx.data.ports.persistence.spi.AccountRepositoryPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        String encryptedPassword = new BCryptPasswordEncoder().encode(account.getPassword());

        account.setPassword(encryptedPassword);

        return repository.add(AccountAdapter.toPostgres(account));
    }
}

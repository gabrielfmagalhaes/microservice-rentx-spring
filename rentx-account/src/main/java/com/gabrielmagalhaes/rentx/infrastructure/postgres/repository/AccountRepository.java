package com.gabrielmagalhaes.rentx.infrastructure.postgres.repository;

import com.gabrielmagalhaes.rentx.infrastructure.postgres.entity.PostgresAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface AccountRepository extends ReactiveCrudRepository<PostgresAccount, UUID> {
}

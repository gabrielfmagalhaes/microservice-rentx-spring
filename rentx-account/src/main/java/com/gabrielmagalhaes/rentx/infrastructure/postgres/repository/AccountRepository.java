package com.gabrielmagalhaes.rentx.infrastructure.postgres.repository;

import com.gabrielmagalhaes.rentx.infrastructure.postgres.entity.PostgresAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface AccountRepository extends ReactiveMongoRepository<PostgresAccount, UUID> {
}

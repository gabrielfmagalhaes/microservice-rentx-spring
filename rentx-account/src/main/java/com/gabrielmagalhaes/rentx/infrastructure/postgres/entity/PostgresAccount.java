package com.gabrielmagalhaes.rentx.infrastructure.postgres.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@Document(collection = "account")
public class PostgresAccount {

    @MongoId
    private Long id;
    private String name;
    private String email;

    private String password;

    private boolean admin;
}

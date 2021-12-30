package com.gabrielmagalhaes.rentx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
@EnableFeignClients
public class RentxAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentxAccountApplication.class, args);
    }

}

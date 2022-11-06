package com.example.restwebfluxservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestWebfluxServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(RestWebfluxServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestWebfluxServiceApplication.class, args);
    }

}

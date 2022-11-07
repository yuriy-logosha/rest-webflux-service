package com.example.restwebfluxservice;

import com.example.restwebfluxservice.adapter.SoapServiceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestWebfluxServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(RestWebfluxServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestWebfluxServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner verify(SoapServiceAdapter client) {
        return args -> {
            String msg = "111";

            if (args.length > 0) {
                msg = args[0];
            }
            Integer code = client.getResultCode(msg);
            log.info("ResultCode: " + code);

            assert code == 111;
        };
    }
}

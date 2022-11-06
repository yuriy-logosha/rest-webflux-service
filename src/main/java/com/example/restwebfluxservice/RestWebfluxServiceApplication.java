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


//    @Bean
//    CommandLineRunner verify(ResultCodeClient client) {
//        return args -> {
////            String msg = "111";
////
////            if (args.length > 0) {
////                msg = args[0];
////            }
////            Integer code = client.getResultCode(msg);
////            log.info("ResultCode: " + code);
////
////            assert code == 111;
//
//
////            WebClient.create("http://localhost:8080/data/create").post()
//////                    .contentType(MediaType.APPLICATION_JSON)
////                    .body(BodyInserters.fromValue("{\n" +
////                            "\"message\":\"12345\",\n" +
////                            "\"id\":1\n" +
////                            "}"))
////                    .retrieve()
////                    .bodyToMono(String.class)
////                    .doOnNext(s -> System.out.println(s));
//
//            IncomingData m = new IncomingData();
//            m.setMessage("112233");
//            m.setId("123");
//            WebClient.create("http://localhost:8080/data").post()
//                    .uri("/create")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromObject(m))
//                    .exchange().log();
////            webClient.post()
////                    .contentType(MediaType.APPLICATION_JSON)
////                    .body(BodyInserters.fromValue(body))
////
////                    .exchangeToMono(response -> {
////                        if (response.statusCode().equals(HttpStatus.OK)) {
////                            return response.bodyToMono(Integer.class);
////                        } else {
////                            return response.createException().flatMap(Mono::error);
////                        }
////                    });
//
//        };
//    }
}

package com.example.restwebfluxservice.controller;

import com.example.restwebfluxservice.adapter.SoapServiceAdapter;
import com.example.restwebfluxservice.model.IncomingData;
import com.example.restwebfluxservice.repository.IncomingDataRepository;
import com.example.restwebfluxservice.service.IncomingDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = IncomingDataController.class)
@Import(IncomingDataService.class)
public class IncomingDataControllerTest {

    private static final String TEST_MSG = "2022";
    private static final int TEST_SOAP_RESULT = 2022;
    @MockBean
    IncomingDataRepository repository;

    @MockBean
    SoapServiceAdapter client;

    @Autowired
    private WebTestClient webClient;

    @Test
    void testCreate() {
        IncomingData message = new IncomingData();
        message.setMessage(TEST_MSG);
        message.setId(TEST_MSG);

        when(repository.save(message)).thenReturn(message);
        when(client.getResultCode(TEST_MSG)).thenReturn(TEST_SOAP_RESULT);

        webClient.post()
                .uri("/data/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(message))
                .exchange()
                .expectStatus().isOk()
                .expectBody().equals(TEST_SOAP_RESULT);

        Mockito.verify(repository, times(1)).save(any());
    }

}
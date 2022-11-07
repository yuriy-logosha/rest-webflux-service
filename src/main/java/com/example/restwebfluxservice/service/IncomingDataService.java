package com.example.restwebfluxservice.service;

import com.example.restwebfluxservice.adapter.SoapServiceAdapter;
import com.example.restwebfluxservice.model.IncomingData;
import com.example.restwebfluxservice.repository.IncomingDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class IncomingDataService {

    private static final Logger log = LoggerFactory.getLogger(IncomingDataService.class);

    private final IncomingDataRepository incomingDataRepository;
    private final SoapServiceAdapter client;

    public IncomingDataService(IncomingDataRepository incomingDataRepository, SoapServiceAdapter client) {
        this.incomingDataRepository = incomingDataRepository;
        this.client = client;
    }

    public Mono<String> create(IncomingData data) {
        return Mono.defer(() -> {
            data.setMessage(client.getResultCode(data.getMessage()) + "");
            IncomingData saved = incomingDataRepository.save(data);
            return Mono.just(saved.getId());
        });
    }
}

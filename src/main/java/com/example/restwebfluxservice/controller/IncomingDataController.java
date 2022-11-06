package com.example.restwebfluxservice.controller;

import com.example.restwebfluxservice.service.IncomingDataService;
import com.example.restwebfluxservice.model.IncomingData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import reactor.core.publisher.Mono;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

@RestController
@RequestMapping("/data")
public class IncomingDataController {

    private final IncomingDataService incomingDataService;

    public IncomingDataController(IncomingDataService incomingDataService) {
        this.incomingDataService = incomingDataService;
    }

    @PostMapping("/create")
    public Mono<Integer> create(@RequestBody IncomingData data) {
        RequestContextHolder.currentRequestAttributes().setAttribute("id", data.getId(), SCOPE_REQUEST);
        Mono mono = incomingDataService.create(data);
        return mono;
    }

}

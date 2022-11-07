package com.example.restwebfluxservice.controller;

import com.example.restwebfluxservice.service.IncomingDataService;
import com.example.restwebfluxservice.model.IncomingData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/data")
public class IncomingDataController {

    private final IncomingDataService incomingDataService;

    public IncomingDataController(IncomingDataService incomingDataService) {
        this.incomingDataService = incomingDataService;
    }

    @PostMapping("/create")
    public Mono<String> create(@RequestBody IncomingData data) {
        return incomingDataService.create(data).contextWrite(ctx -> ctx.put("id", data.getId()));
    }

}

package com.example.restwebfluxservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import us.world_corp.my_soap_forum.*;


@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "us.world_corp.my_soap_forum";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "message")
    @ResponsePayload
    public Resultcode messageHandler(@RequestPayload Message request) {
        Resultcode resultObject = new ObjectFactory().createResultcode();
        resultObject.setValue(Integer.parseInt(request.getValue()));
        return resultObject;
    }
}

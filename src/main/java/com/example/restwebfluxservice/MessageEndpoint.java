package com.example.restwebfluxservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xsd.my_soap_forum.world_corp.us.Message;
import xsd.my_soap_forum.world_corp.us.ObjectFactory;
import xsd.my_soap_forum.world_corp.us.Resultcode;

@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "xsd.my_soap_forum.world_corp.us";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "message")
    @ResponsePayload
    public Resultcode messageHandler(@RequestPayload Message request) {
        Resultcode resultObject = new ObjectFactory().createResultcode();
//        try {
        resultObject.setValue(Integer.parseInt(request.getValue()));
        return resultObject;
//        } catch (NumberFormatException e) {
//            throw new ServiceFaultException(e.getLocalizedMessage());
//        }
    }
}

package com.example.restwebfluxservice.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import us.world_corp.my_soap_forum.*;


public class SoapServiceAdapter extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SoapServiceAdapter.class);

    public Integer getResultCode(String message) {

        Message msg = new Message();
        msg.setValue(message);

        Resultcode resp = (Resultcode) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/message", msg,
                        new SoapActionCallback(""));

        return resp.getValue();
    }
}

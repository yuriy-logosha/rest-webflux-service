package com.example.restwebfluxservice.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.*;

public class SoapClientInterceptor implements ClientInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SoapClientInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        WebServiceMessage message = messageContext.getResponse();
        SaajSoapMessage saajSoapMessage = (SaajSoapMessage) message;
        SOAPMessage soapMessage = saajSoapMessage.getSaajMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        try {
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPFault soapFault = soapBody.getFault();
            log.error(String.format("Error occurred while invoking web service - %s ", soapFault.getFaultString()));
//            throw new RuntimeException(String.format("Error occurred while invoking web service - %s ",soapFault.getFaultString()));
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {

    }
}

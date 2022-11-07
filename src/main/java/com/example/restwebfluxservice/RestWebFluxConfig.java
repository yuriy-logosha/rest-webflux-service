package com.example.restwebfluxservice;

import com.example.restwebfluxservice.adapter.SoapServiceAdapter;
import com.example.restwebfluxservice.interceptor.SoapClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

@Configuration
public class RestWebFluxConfig {

    private static final String SOAP_NAMESPACE = "us.world_corp.my_soap_forum";
    private static final String SOAP_SERVER_URI = "http://localhost:80/ws";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(SOAP_NAMESPACE);
        return marshaller;
    }

    @Bean
    public SoapServiceAdapter resultCodeClient(Jaxb2Marshaller marshaller) {
        SoapServiceAdapter client = new SoapServiceAdapter();
        client.setDefaultUri(SOAP_SERVER_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        ClientInterceptor[] interceptors = new ClientInterceptor[]{interceptor()};
        client.setInterceptors(interceptors);
        return client;
    }

    @Bean
    public SoapClientInterceptor interceptor() {
        return new SoapClientInterceptor();
    }

}

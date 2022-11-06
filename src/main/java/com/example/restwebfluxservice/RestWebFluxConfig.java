package com.example.restwebfluxservice;

import com.example.restwebfluxservice.adapter.SoapServiceAdapter;
import com.example.restwebfluxservice.interceptor.SoapClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

@Configuration
public class RestWebFluxConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("xsd.my_soap_forum.world_corp.us");
        return marshaller;
    }

    @Bean
    public SoapServiceAdapter resultCodeClient(Jaxb2Marshaller marshaller) {
        SoapServiceAdapter client = new SoapServiceAdapter();
        client.setDefaultUri("http://localhost:80/ws");
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

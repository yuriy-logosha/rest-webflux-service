package com.example.restwebfluxservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IncomingData {
    @Id
    private String id;
    private String message;
}

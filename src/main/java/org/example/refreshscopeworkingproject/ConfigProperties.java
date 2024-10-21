package org.example.refreshscopeworkingproject;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@RefreshScope
public class ConfigProperties {
    private String message = UUID.randomUUID().toString();

    public String getMessage() {
        return message;
    }
//   Or in Constructor set value
//    public ConfigProperties() {
//        this.message =  UUID.randomUUID().toString();
//    }

    @PostConstruct
    public void init() {
        System.out.println("ConfigProperties bean created with message: " + message);
    }
    @PreDestroy
    public void destroy() {
        System.out.println("ConfigProperties destroyed");
    }
}

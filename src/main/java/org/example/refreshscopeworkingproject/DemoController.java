package org.example.refreshscopeworkingproject;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
public class DemoController {
    private final ConfigProperties configProperties;

    public DemoController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/message")
    public String getMessage() {
        return configProperties.getMessage();
    }


    @PostConstruct
    public void init() {
        System.out.println("Controller initialized");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Controller destroyed");
    }
}
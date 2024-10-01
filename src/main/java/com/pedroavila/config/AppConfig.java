package com.pedroavila.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    /*@PostConstruct
    public void init() {
        System.out.println("Database URL: " + System.getenv("URL"));
        System.out.println("Database User: " + System.getenv("USER_NAME"));
        System.out.println("Database User: " + System.getenv("PASSWORD"));
    }*/
}

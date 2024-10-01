package com.pedroavila.operations.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
public class AppConfig {
    /*@PostConstruct
    public void init() {
        System.out.println("Database URL: " + System.getenv("URL"));
        System.out.println("Database User: " + System.getenv("USER_NAME"));
        System.out.println("Database User: " + System.getenv("PASSWORD"));
    }*/
}

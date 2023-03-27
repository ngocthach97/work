package com.example.traning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TraningApplication {
    public static void main(String[] args) {
        SpringApplication.run(TraningApplication.class, args);
    }
}

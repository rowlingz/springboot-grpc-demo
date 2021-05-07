package com.exapmle.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @PostConstruct
    private void init() {
        System.out.println("Grpc server start ================>");
    }
}
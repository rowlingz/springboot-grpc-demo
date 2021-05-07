package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    private GrpcClient grpcClient;

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @PostConstruct
    private void init() {
        int i = 0;
        while (i < 5) {
            System.out.println(grpcClient.sayHello("占三", String.valueOf(i)));
            i += 1;
        }
    }

}

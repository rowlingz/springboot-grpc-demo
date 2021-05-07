package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/myApp")
public class GrpcClientController {
    @Autowired
    private GrpcClient grpcClient;

    @RequestMapping("/test")
    public String printMessage(@RequestParam(defaultValue = "Susan") String name, @RequestParam(defaultValue = "1") String sex) {
        System.out.println("====");
        return grpcClient.sayHello(name, sex);
    }
}

package com.example.client;

import com.example.grpc.core.GreeterGrpc;
import com.example.grpc.core.HelloReply;
import com.example.grpc.core.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GrpcClient {

    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    // 构造请求
    private HelloRequest convertRequest (String name, String sex) {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName(name)
                .setSex(sex)
                .build();
        return helloRequest;
    }

    public String sayHello (String name, String sex) {
        HelloReply reply = greeterBlockingStub.sayHello(convertRequest(name,sex));
        System.out.println("接收到服务端返回结果: " + reply.getMessage());
        return reply.getMessage();
    }

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8002)
                .usePlaintext()
                .build();
        greeterBlockingStub  = GreeterGrpc.newBlockingStub(managedChannel);
        System.out.println("链接server ==================");
    }
}

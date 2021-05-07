package com.exapmle.server;

import com.example.grpc.core.GreeterGrpc;
import com.example.grpc.core.HelloReply;
import com.example.grpc.core.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

        System.out.println("接收到 GRPC-Client 消息: " + request.getName() + " - " + request.getSex());

        String message = "Hello =======> " + request.getName() + " sex参数 is " + request.getSex();
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        System.out.println("Returning:  " + message);
    }
}

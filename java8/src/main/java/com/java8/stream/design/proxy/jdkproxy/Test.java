package com.java8.stream.design.proxy.jdkproxy;


import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        MyfeignGrpc myfeignGrpc = new MyfeignGrpc();
        myfeignGrpc.feignInvoke();

        Object grpcInterface = Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{GrpcInterface.class}, new JdkProxyInvocation(myfeignGrpc));
//        grpcInterface.feignInvoke();
        System.out.println(grpcInterface.getClass());
        if (grpcInterface instanceof GrpcInterface) {
            ((GrpcInterface) grpcInterface).feignInvoke();
        }

    }
}

package com.java8.stream.design.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxyInvocation implements InvocationHandler {

    public GrpcInterface grpcInterface;

    public JdkProxyInvocation(GrpcInterface grpcInterface) {
        this.grpcInterface = grpcInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("feignInvoke")) {
            System.out.println("代理远程调用了");
            return method.invoke(grpcInterface);
        } else {
            return method.invoke(grpcInterface, args);
        }
    }
}

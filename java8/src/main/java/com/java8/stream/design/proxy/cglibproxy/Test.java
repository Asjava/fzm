package com.java8.stream.design.proxy.cglibproxy;


import com.java8.stream.design.proxy.jdkproxy.GrpcInterface;
import com.java8.stream.design.proxy.jdkproxy.JdkProxyInvocation;
import com.java8.stream.design.proxy.jdkproxy.MyfeignGrpc;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        MyfeignGrpc myfeignGrpc = new MyfeignGrpc();
        myfeignGrpc.feignInvoke();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GrpcInterface.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                return method.invoke(myfeignGrpc, args);
            }
        });
        Object o = enhancer.create();
        GrpcInterface grpcInterface = (GrpcInterface) o;
        grpcInterface.feignInfo();
        grpcInterface.feignInvoke();
    }
}

package com.java8.stream.design.proxy.jdkproxy;

public class MyfeignGrpc implements GrpcInterface{
    @Override
    public void feignInvoke() {
        System.out.println("feignInvoke：自定义远程调用不经过代理");
    }

    @Override
    public void feignInfo() {
        System.out.println("feignInfo：自定义远程调用不经过代理");
    }
}

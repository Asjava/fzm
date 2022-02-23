package com.java8.stream.design.filter;

public class ParamFilter implements Filter{
    public void execute(String request) {
        System.out.println("ParamFilter do " + request);
    }
}

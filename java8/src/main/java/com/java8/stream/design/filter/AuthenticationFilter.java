package com.java8.stream.design.filter;

public class AuthenticationFilter implements Filter{
    public static Filter filter = new AuthenticationFilter();

    public void execute(String request) {
        System.out.println("AuthenticationFilter do " + request);
    }
}

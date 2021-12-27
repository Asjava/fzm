package com.java8.stream.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
public class SpringBootEventListenerDemo {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventListenerDemo.class)
                .listeners(event ->{
                    System.err.println("监听到事件： " + event.getClass().getSimpleName());
                })
                .run()
                .close();
    }
}

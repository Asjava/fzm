package com.fxs.fzmnacosclientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@SpringBootApplication
@EnableDiscoveryClient
public class FzmNacosClientServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmNacosClientServerApplication.class, args);
    }

}

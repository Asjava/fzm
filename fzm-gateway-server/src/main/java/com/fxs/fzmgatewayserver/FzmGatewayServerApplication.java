package com.fxs.fzmgatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FzmGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmGatewayServerApplication.class, args);
    }

}

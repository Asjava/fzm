package com.fxs.fzmnacosconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableWebMvc
public class FzmNacosConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmNacosConfigServerApplication.class, args);
    }

}

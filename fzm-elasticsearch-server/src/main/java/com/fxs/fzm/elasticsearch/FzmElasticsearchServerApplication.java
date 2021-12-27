package com.fxs.fzm.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class FzmElasticsearchServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmElasticsearchServerApplication.class, args);
    }

}

package com.fxs.fzm.security;

import com.fxs.fzm.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.fxs.fzm.security.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
@ComponentScan(basePackages = "com.fxs.fzm")
public class FzmSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmSecurityServerApplication.class, args);
    }

}

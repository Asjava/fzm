package com.fxs.fzm.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
//启动事务控制
@EnableTransactionManagement
@MapperScan(basePackages = "com.fxs.fzm.order.mapper")
@ComponentScan(basePackages = "com.fxs.fzm")
public class FzmOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FzmOrderServerApplication.class, args);
    }

}

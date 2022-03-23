package com.provider.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient   //eureka客户端注解配置
public class CheneyProviderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheneyProviderServerApplication.class, args);
    }

}

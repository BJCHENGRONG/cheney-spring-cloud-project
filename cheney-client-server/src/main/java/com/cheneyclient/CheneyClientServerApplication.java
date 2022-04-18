package com.cheneyclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //Eureka客户端
// feign的接口在哪个包下，就扫描哪个包
//@EnableFeignClients(basePackages = {"com.cheneyclient"})
@EnableFeignClients    //开启Feign组件
@MapperScan("com.cheneyclient.dao")// 那一层继承了BaseMapper就对那一层进行扫描

public class CheneyClientServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheneyClientServerApplication.class, args);
    }

}

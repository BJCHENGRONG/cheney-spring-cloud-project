package com.cheneyclient.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cheneyclient.dao")
public class PageConfig {
    @Bean
    public PaginationInterceptor PaginationInterceptor() {
        return new PaginationInterceptor();
    }
}


package com.cheneycloud.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayRoutes {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //client模块
                .route(p -> p.path("/c1/**")
                        .filters(buildFilter("c1"))
                        .uri("lb://cheney-client-server/c1"))
                // provider模块
                .route(
                        p -> p.path("/p1/**")
                                .filters(buildFilter("p1"))
                                .uri("lb://cheney-provider-server/p1")
                ).build();
    }

    private Function buildFilter(String pathName) {
        return new Function<GatewayFilterSpec, UriSpec>() {
            @Override
            public UriSpec apply(GatewayFilterSpec f) {
                return f.addRequestHeader("Hello", "World")
                        //.stripPrefix(1)
                        .hystrix(h -> h.setName("default").setFallbackUri("forward:/defaultfallback?pathName=" + pathName));
            }
        };

    }
}

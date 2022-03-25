package com.cheneycloud.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @Bean
 *        public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
 * 		return builder.routes()
 * 				.route("path_route", r -> r.path("/about")
 * 						.uri("http://ityouknow.com"))
 * 				.build();
 *    }
 *   上面配置了一个 id 为 path_route 的路由，当访问地址http://localhost:8080/about时
 *   会自动转发到地址：http://www.ityouknow.com/about和上面的转发效果一样，只是这里转发的是以项目地址/about格式的请求地址。
 *   上面两个示例中 uri 都是指向了我的个人网站，在实际项目使用中可以将 uri 指向对外提供服务的项目地址，统一对外输出接口。
 */

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

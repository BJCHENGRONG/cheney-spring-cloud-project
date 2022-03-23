package com.cheneycloud.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 全局拦截器
 * 登录验证、token校验等
 * 注：跨域请求必须先处理跨域问题，才能进行GlobalFilter处理
 * 之前的访问是直接访问子服务的链接，如：http://localhost:10084/c1/client/feignLogin04 (10084是子服务的端口)
 * 现在有了网关了后，需要使用网关的端口访问了，如：http://localhost:10082/c1/client/feignLogin04 (10082是网关gateway服务的端口)
 **/
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private static Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);

    //@Autowired
//    private TokenUtil tokenUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpResponse response = serverWebExchange.getResponse();
        if (true) {
            //if (!tokenUtil.passToken(request)) {
            JSONObject msg = new JSONObject();
            msg.put("message", "PLEASE LOGIN IN！！！");
            msg.put("msg", "PLEASE LOGIN IN！！！");
            byte[] bits = msg.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
            //}
        }

        return gatewayFilterChain.filter(serverWebExchange);
    }

    @Override
    public int getOrder() {
        return -300;
    }

}

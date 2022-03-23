package com.cheneycore.contants;

public class SYSCoreContants {

    /**
     * 插件：Feign
     * Eureka注册的服务名称：cheney-provider-server
     * CONTEXT_PATH如果没有进行配置，那么就直接写“/”
     */
    public static final String CHENEY_PROVIDER_SERVER = "cheney-provider-server";
    public static final String CHENEY_PROVIDER_SERVER_CONTEXT_PATH = "/p1";

    /**
     * 插件：Hystrix
     * 针对cheney-provider-server服务进行熔断器返回统一消息
     */
    public static final String CHENEY_PROVIDER_SERVER_HYSTRIX_MSG = "本次请求被失效！请检查注册中心服务（cheney-provider-server）是否有效？或者联系管理员！";
}

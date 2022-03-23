package com.cheneyclient.service;

import com.cheneyclient.service.hystrix.FeignHystrixFallback;
import com.cheneycore.contants.SYSCoreContants;
import com.cheneycore.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这里是当前这个相同作为客户端，去调用cheney-provider-server项目中的接口，
 * 因为都是在同一个注册中心Eureka中，所以本次接口声明配置如下;
 * Feign组件以抽象方法的形式表示调用,feign底层会自动转化对象类型,使用requestMapping注解来表示你要调用那个请求
 * cheney-provider-server:注册中心的provider的项目名称,注意大小写（如果不行就复制Eureka中的注册的名字）
 * Feign一般是哪个客户端需要去做远程调用，那么就在哪个客户端做Feign注解，包括在CheneyClientServerApplication中通过注解@EnableFeignClients开启Feign定义
 * 如果系统无法识别Feign那么记得去install项目cheney-provider-server
 * Hystrix熔断器通过回调实现类类实现（如果需要熔断器Hystrix那么可以删除 fallback = FeignHystrixFallback.class 这个配置 ）
 * 如果后台项目配置了context-path 那么下面的path就需要加上，否则就删除path
 */

@FeignClient(name = SYSCoreContants.CHENEY_PROVIDER_SERVER, path = SYSCoreContants.CHENEY_PROVIDER_SERVER_CONTEXT_PATH, fallback = FeignHystrixFallback.class)
public interface ClientFeignClientService {


    /**
     * 这里的访问路和接口参数方式必须和服务端提供的方法一样
     * 注意参数：
     * 这个参数少了个value = “XXCode”, 这个是Spring 4.0版本后，@RequestParam 注解对参数传值有了很好的封装特性并严格校验。
     * 改为：@RequestParam(value = “loginName”, required = false) String loginName
     */
    @RequestMapping(value = "/provider/feignLogin01", method = RequestMethod.GET)
    String getSupplierCapacities01(@RequestParam(value = "loginName", required = false) String loginName);


    /**
     * 多个参数测试
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    @RequestMapping(value = "/provider/feignLogin02", method = RequestMethod.GET)
    String getSupplierCapacities02(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "loginPwd", required = false) String loginPwd);

    /**
     * 实体参数
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/provider/feignLogin03", method = RequestMethod.POST)
    String getSupplierCapacities03(@RequestBody User user);

    /**
     * 测试四（Ribbon 客户端负载均衡）
     * JavaBean参数 User
     */
    @RequestMapping(value = "/provider/feignLogin04", method = RequestMethod.POST)
    String getSupplierCapacities04(@RequestParam(value = "loginName", required = false) String loginName,
                                   @RequestParam(value = "loginPwd", required = false) String loginPwd,
                                   @RequestParam(value = "reqCount", required = false) String reqCount);


}

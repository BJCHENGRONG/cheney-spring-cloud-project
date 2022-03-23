package com.cheneyclient.service.hystrix;

import com.cheneyclient.service.ClientFeignClientService;
import com.cheneycore.contants.SYSCoreContants;
import com.cheneycore.model.User;
import org.springframework.stereotype.Component;

/**
 * 注意：这里的实现是回调是针对Hystrix熔断器设置的，也就是说如果Feign组件远程调用失败就会返回这里的数据
 * 这里的方法都是String返回值，所以需要返回一个一次消息
 * 如果方法是void那么需要做日志或者其他方式处理
 * 注意：这里不是实现类，所以不能使用注解 @Service ,因为是一个顶包组件所以使用  @Component
 */
@Component
public class FeignHystrixFallback implements ClientFeignClientService {

    @Override
    public String getSupplierCapacities01(String loginName) {
        //[本次请求被失效！请检查注册中心服务（cheney-provider-server）是否有效？或者联系管理员！]
        return SYSCoreContants.CHENEY_PROVIDER_SERVER_HYSTRIX_MSG;
    }

    @Override
    public String getSupplierCapacities02(String loginName, String loginPwd) {
        //[本次请求被失效！请检查注册中心服务（cheney-provider-server）是否有效？或者联系管理员！]
        return SYSCoreContants.CHENEY_PROVIDER_SERVER_HYSTRIX_MSG;
    }

    @Override
    public String getSupplierCapacities03(User user) {
        //[本次请求被失效！请检查注册中心服务（cheney-provider-server）是否有效？或者联系管理员！]
        return SYSCoreContants.CHENEY_PROVIDER_SERVER_HYSTRIX_MSG;
    }

    @Override
    public String getSupplierCapacities04(String loginName, String loginPwd, String count) {
        //[本次请求被失效！请检查注册中心服务（cheney-provider-server）是否有效？或者联系管理员！]
        return SYSCoreContants.CHENEY_PROVIDER_SERVER_HYSTRIX_MSG;
    }
}

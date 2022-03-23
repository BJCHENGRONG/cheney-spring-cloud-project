package com.provider.demo.controller;

import com.cheneycore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 测试Feign组件,下面的方法也可以本地请求调用，其他服务也可以通过Feign组件实现远程调用
 * 调用请参见cheney-client-server
 */
@RestController
//@RequestMapping("/provider")  如果Feign结合了Hystrix使用的话，这里不要添加 @RequestMapping 这个注解，链接直接写在方法民资的映射路径上
public class FeignProviderController {
    private Logger logger = LoggerFactory.getLogger(FeignProviderController.class);

    /**
     * 测试一（这里也作为客户端服务通过Feign调用这里）
     * 单个参数
     *
     * @param loginName
     * @return
     */
    @RequestMapping(value = "/provider/feignLogin01", method = RequestMethod.GET)
    public String getSupplierCapacities01(@RequestParam(value = "loginName", required = false) String loginName) {
        return "您好：" + loginName + "; 当前时间是：" + String.valueOf(System.currentTimeMillis());
    }

    /**
     * 测试二（这里也作为客户端服务通过Feign调用这里）
     * 多个参数
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    @RequestMapping(value = "/provider/feignLogin02", method = RequestMethod.GET)
    public String getSupplierCapacities02(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "loginPwd", required = false) String loginPwd) {
        return "您好：" + loginName + ";  密码是：" + loginPwd + "  当前时间是：" + String.valueOf(System.currentTimeMillis());
    }

    /**
     * 测试三（这里也作为客户端服务通过Feign调用这里）
     * JavaBean参数 User
     */
    @RequestMapping(value = "/provider/feignLogin03", method = RequestMethod.POST)
    public String getSupplierCapacities03(@RequestBody User user) {
        return "您好：" + user.getLoginName() + ";  密码是：" + user.getLoginPwd() + "  当前时间是：" + user.getLoginTime();
    }

    /**
     * 测试四（Ribbon 客户端负载均衡）
     * JavaBean参数 User
     */
    @RequestMapping(value = "/provider/feignLogin04", method = RequestMethod.POST)
    public String getSupplierCapacities04(@RequestParam(value = "loginName", required = false) String loginName,
                                          @RequestParam(value = "loginPwd", required = false) String loginPwd,
                                          @RequestParam(value = "reqCount", required = false) String reqCount) {
        logger.info("端口：10085 中 Ribbon 测试结果值为：================》 " + reqCount);
        return "您好：" + loginName + ";  密码是：" + loginPwd + "  当前时间是：" + String.valueOf(System.currentTimeMillis());
    }

}

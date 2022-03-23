package com.cheneyclient.controller;

import com.cheneyclient.service.ClientFeignClientService;
import com.cheneycore.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientFeignTestController {
    @Autowired
    ClientFeignClientService feignClientService;

    /**
     * 这里是一个GET的方式测试链接
     * 测试地址链接：http://localhost:10084/c1/client/feignLogin01?loginName=chengrong
     *
     * @param loginName
     * @return
     */
    @RequestMapping(value = "/feignLogin01", method = RequestMethod.GET)
    public String getSupplierCapacities01(@RequestParam(value = "loginName", required = false) String loginName) {
        return "收到组件成功返回-》" + feignClientService.getSupplierCapacities01(loginName);
    }


    /**
     * 这里是一个GET的方式测试链接
     * 测试地址链接：http://localhost:10084/c1/client/feignLogin02?loginName=chengrong&loginPwd=123456
     *
     * @param loginName
     * @return
     */
    @RequestMapping(value = "/feignLogin02", method = RequestMethod.GET)
    public String getSupplierCapacities02(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "loginPwd", required = false) String loginPwd) {
        return "收到组件成功返回-》" + feignClientService.getSupplierCapacities02(loginName, loginPwd);
    }

    /**
     * 实体参数测试
     * http://localhost:10084/c1/client/feignLogin03
     * POSTMAN:新增： Headers->Content-Type=application/json
     * BODY->Raw
     * {
     * "loginName":"loginName",
     * "loginPwd":"loginPwd",
     * "loginTime":"loginTime"
     * }
     * POST
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/feignLogin03", method = RequestMethod.POST)
    public String getSupplierCapacities03(@RequestBody User user) {
        return "收到组件成功返回-》" + feignClientService.getSupplierCapacities03(user);
    }

    /**
     * 测试四（Ribbon 客户端负载均衡）
     * http://localhost:10084/c1/client/feignLogin04
     * PostMan: body->raw -> 通过JSON格式传参
     * {
     * "loginName":"loginName",
     * "loginPwd":"loginPwd",
     * "count":10
     * }
     * <p>
     * 1、注意：这里没有去配置Ribbon的策略规则的话，默认是使用Ribbon默认(轮询策略:RoundRobinRule)的策略，如果要指定策略的话那么需要去application.yml中去指定
     * 2、参数说明：前端调用的时候突然发现一直报错：‘xxx’ is not present  ，通过排查之后终于找到了原因；
     * 3、原来前端的请求头中的Content-Type设置的是json格式的，而json格式需要对应post请求的接口参数需要对应是@RequestBody；
     * 4、如果想使用RequestParam，那么则需要前端的Content-Type要设置成application/x-www-form-urlencoded类型。
     * 5、注意：这里的ribbon无需引用其他的pom依赖，ribbon已经整合在eureka服务包中，所以无需引用其他包
     * 6、这里的ribbon负载均衡默认是开启的无需额外开启，也没有其他配置，这是Eureka中自带的功能
     * 7、默认的Ribbon策略是轮训策略，如果改变策略那么需要到配置文件中去设置，针对微服务中每一个服务区设置改变如：
     * cheney-provider-server:#这个是微服务的id
     * ribbon:
     * NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #随机策略
     */
    @PostMapping(value = "/feignLogin04")
    public String getSupplierCapacities04(@RequestBody Map<String, Object> paramMap) {
        String resultMsg = "";
        if (!CollectionUtils.isEmpty(paramMap)) {
            String loginName = paramMap.get("loginName").toString();
            String loginPwd = paramMap.get("loginPwd").toString();
            String reqCount = paramMap.get("reqCount").toString();
            if (!StringUtils.isBlank(reqCount)) {
                //reqCount需要校验是否为数字
                int count = Integer.parseInt(reqCount);
                for (int i = 0; i < count; i++) {
                    /**
                     * 执行到这里可以就看到Cheney-provider-server和Cheney-provider-ribbon-server两个项目的控制台打印了
                     */
                    resultMsg = feignClientService.getSupplierCapacities04(loginName, loginPwd, String.valueOf(i));

                }
            }
        }
        if (StringUtils.isBlank(resultMsg)) {
            resultMsg = "Ribbon-负载均衡已经调用完成";
        }
        return resultMsg;
    }

}

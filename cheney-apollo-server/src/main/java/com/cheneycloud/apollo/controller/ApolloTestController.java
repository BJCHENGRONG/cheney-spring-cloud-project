package com.cheneycloud.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apollo")
public class ApolloTestController {

    /**
     * Apollo测试
     * 这里是一个GET的方式测试链接
     * 测试地址链接：http://localhost:10082/a1/apollo/test01?paramName=chengrong
     * VM Options : -Dapp.id=cheney--apollo-1 -Denv=DEV -Ddev_meta=http://localhost:8080/
     * 注意：Ddev_meta配置的是configServer的地址
     *  ##################### APOLLO 说明 ###########################################
     *  1、Config Services提供配置的读取，推送等功能，服务对象是Apollo客户端（Config本身自带Eureka服务）
     *  2、Admin Services提供配置的修改，发布等功能，服务对象是Apollo Portal（管理界面）
     *  3、Eureka提供服务注册和发现，为了简单起见，目前Eureka在部署是和Config Service是在一个JVM进程中
     *  4、Config Service和Admin Service都是多实例，无状态部署，所以需要讲自己注册到Eureka中，在Eureka上架了一层Meta Server用于封装Eureka的服务发现接口
     *  ##################### APOLLO 说明 ###########################################
     */
    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public String getSupplierCapacities01(@RequestParam(value = "paramName", required = false) String paramName) {
        Map<String, Object> pMap = new HashMap<String, Object>();
        //初始化Apollo配置对象（这是读取默认application的命名空间的的参数信息）
        Config config = ConfigService.getAppConfig();
        String key1 = config.getProperty("cheney.key1", "默认值1");
        String key2 = config.getProperty("cheney.key2", "默认值2");
        pMap.put("cheney.key1", key1);
        pMap.put("cheney.key2", key2);

        //读取私有命名空间的值
        Config config2 = ConfigService.getConfig("TEST1.CHENEY-NAME-SPACE-1");
        String key3 = config2.getProperty("cheney.key3", "默认值3");
        String key4 = config2.getProperty("cheney.key4", "默认值4");
        pMap.put("cheney.key3", key3);
        pMap.put("cheney.key4", key4);

        return new Gson().toJson(pMap);
    }

}

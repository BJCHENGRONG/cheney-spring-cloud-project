package com.cheneyclient.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableKnife4j
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfiguration {
//    @Value("${swagger.show}")
//    private boolean swaggerShow;

//    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("微服务客户端（cheney-client-server）API说明技术文档")
                        .description("我的描述")
                        // .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("CHENEY", "https://xxxx.com", "cheney_chen@hgplan.cn"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("all")
                .select()
                //指定Controller扫描路径。可以不具体到controller，它会扫描指定路径下的所有
                .apis(RequestHandlerSelectors.basePackage("com.cheneyclient.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}

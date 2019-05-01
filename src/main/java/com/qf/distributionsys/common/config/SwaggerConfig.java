package com.qf.distributionsys.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:56
 */
@Configuration
public class SwaggerConfig {
    public ApiInfo createApi(){
        return new ApiInfoBuilder().title("分销系统意在打造一个基于互联网+的平台").
                description("分销系统意在打造一个基于互联网+的平台").
                contact(new Contact("likeGalaxy","http://likeGalaxy.com","110@163.com")).build();
    }

    @Bean  //等价于 <bean>标签
    public Docket createDoc(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApi()).select().
                apis(RequestHandlerSelectors.basePackage("com.qf.distributionsys.contorller")).build();
    }
}

package com.mac.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2
 * 该项目访问地址：http://127.0.0.1:8086/demo/swagger-ui.html#/
 * 新版访问地址：http://127.0.0.1:8086/demo/doc.html
 * @author wangxl
 * @date 2019/8/16 20:19
 */

@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mac.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学生考试成绩分析系统测试专用")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("www.wangxianlin@icloud.com")
                .version("1.0")
                .build();
    }

}

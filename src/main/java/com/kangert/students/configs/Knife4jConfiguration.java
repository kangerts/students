/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-06-23 16:00:04
 * @LastEditTime: 2021-06-23 16:11:10
 * @Description:Swagger配置依赖 package com.kangert.students.configs;
 */
package com.kangert.students.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("kangert RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs").termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("kangert", "https://github.com/kangerts", "kangert@qq.com"))
                        .version("v1.0").build())
                // 分组名称
                .groupName("2.X版本").select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.kangert.students.modules.system.controllers"))
                .paths(PathSelectors.any()).build();
        return docket;
    }
}
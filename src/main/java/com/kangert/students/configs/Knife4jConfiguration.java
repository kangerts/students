/**
 * @Author: kangert
 * @Email: kangert@qq.com
 * @Date: 2021-06-23 16:00:04
 * @LastEditTime: 2021-06-29 15:56:37
 * @Description:Swagger配置依赖 package com.kangert.students.configs;
 */
package com.kangert.students.configs;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;

import org.springframework.beans.factory.annotation.Autowired;
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
@EnableKnife4j
public class Knife4jConfiguration {

    /* 引入Knife4j提供的扩展类 */
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public Knife4jConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        String groupName = "2.X版本";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("kangert RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs").termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("kangert", "https://github.com/kangerts", "kangert@qq.com"))
                        .version("v1.0").build())
                // 分组名称
                .groupName(groupName).select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.kangert.students.modules.system.controllers"))
                .paths(PathSelectors.any()).build()
                // 赋予插件体系
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }
}
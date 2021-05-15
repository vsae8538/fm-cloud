package com.github.vsae.web.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerUIConfig {

    @Value("${swagger.host}")
    private String swaggerHost;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .host(this.swaggerHost)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.vsae.web.api.controller"))
                .paths(PathSelectors.any()).build()
                .securitySchemes(securitySchemes());
    }

    private List<ApiKey> securitySchemes() {
        return newArrayList(new ApiKey("token", "Authorization", "header"));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Fm API Document")
                .description("Welcome")
                .version("0.0.1").build();
    }

}

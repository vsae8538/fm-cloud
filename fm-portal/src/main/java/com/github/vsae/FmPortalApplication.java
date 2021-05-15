package com.github.vsae;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@MapperScan(basePackages = "com.github.vsae.web" , annotationClass = Mapper.class)
@ComponentScan({"com.github.vsae"})
@SpringBootApplication
public class FmPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmPortalApplication.class, args);
    }

}

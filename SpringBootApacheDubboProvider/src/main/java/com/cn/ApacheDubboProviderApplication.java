package com.cn;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-03 15:22
 **/
@EnableDubbo
@SpringBootApplication
public class ApacheDubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboProviderApplication.class, args);
    }
}

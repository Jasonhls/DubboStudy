package com.cn;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.导入依赖
 *      1）导入dubbo-starter
 *      2)导入dubbo的其他依赖
*   SpringBoot与dubbo整合的三种方式：
 *   1）导入dubbo-starter，在application.properties中配置属性，使用@Service暴露服务和@Reference引用服务，
 *          其中@EnableDubbo主要是开启包扫描，也可以在application.properties中配置dubbo.scan.base-packages=com.cn.service.impl配置包扫描
 *   2）保留dubbo xml配置文件，在启动类上添加注解@ImportResource(locations=""classpath:provider.xml)，
 *          导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
 *          这种暴露service和引用service都在xml配置文件中，因此不用使用@Service注解和@Reference注解
 *   3）使用注解API方式：具体配置方法可以参考官网
 *          将每一个组件手动创建到容器中，让dubbo来扫描其他的组件。
 *          然后在启动类上添加扫描包的注解，用@DubboComponentScan(value = "com.cn")或@EnableDubbo(scanBasePackages = {"com.cn"})
 *
 */
@EnableDubbo(scanBasePackages = {"com.cn"})//开启基于注解的dubbo功能
@SpringBootApplication
//@DubboComponentScan(basePackages = {"com.cn"})
public class SpringBootDubboServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboServiceProviderApplication.class, args);
    }
}

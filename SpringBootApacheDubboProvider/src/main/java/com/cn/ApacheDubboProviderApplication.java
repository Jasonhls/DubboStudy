package com.cn;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-03 15:22
 * 启动类会作为一个ConfigurationClass，它的属性importBeanDefinitionRegistrars的值如下：
 * {DubboConfigConfigurationRegistrar@3327}  -> {StandardAnnotationMetadata@3326}
 * {DubboComponentScanRegistrar@3350}  -> {StandardAnnotationMetadata@3326}
 * {AutoConfigurationPackages$Registrar@3351}  -> {StandardAnnotationMetadata@3326}
 * {EnableConfigurationPropertiesRegistrar@3352}  -> {StandardAnnotationMetadata@3326}
 * {ConfigurationPropertiesScanRegistrar@3353}  -> {StandardAnnotationMetadata@3326}
 *
 * 解释：
 * @EnableDubbo注解包含了两个子注解@EnableDubboConfig和@DubboComponentScan
 * @EnableDubboConfig注解import了DubboConfigConfigurationRegistrar.class
 * @DubboComponentScan注解import了DubboComponentScanRegistrar.class
 *
 * @SpringBootApplication注解包含子注解@EnableAutoConfiguration和@ConfigurationPropertiesScan
 *
 * @EnableAutoConfiguration注解import了AutoConfigurationImportSelector.class
 *
 * @ConfigurationPropertiesScan注解import了ConfigurationPropertiesScanRegistrar.class，
 * 而@ConfigurationPropertiesScan注解又包含了子注解@EnableConfigurationProperties，
 * @EnableConfigurationProperties注解import了EnableConfigurationPropertiesRegistrar.class
 **/
@EnableDubbo
@SpringBootApplication
public class ApacheDubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboProviderApplication.class, args);
    }
}

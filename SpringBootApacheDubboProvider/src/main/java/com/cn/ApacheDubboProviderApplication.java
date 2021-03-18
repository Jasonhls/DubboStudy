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
 * 注解@EnableDubbo包含了两个子注解@EnableDubboConfig和@DubboComponentScan
 * 注解@EnableDubboConfig注解import了  DubboConfigConfigurationRegistrar.class
 * 注解@DubboComponentScan注解import了  DubboComponentScanRegistrar.class
 *
 * 注解@SpringBootApplication注解包含子注解@EnableAutoConfiguration和@ConfigurationPropertiesScan
 *
 * 注解@EnableAutoConfiguration  import了  AutoConfigurationImportSelector.class（这个不属于ImportBeanDefinitionRegistrar类型）
 * 注解@ConfigurationPropertiesScan import了  ConfigurationPropertiesScanRegistrar.class，
 *
 * 而注解@EnableAutoConfiguration又包含了子注解@AutoConfigurationPackage，
 *     注解@AutoConfigurationPackage import了org.springframework.boot.autoconfigure.AutoConfigurationPackages的内部类Registrar，
 *     即org.springframework.boot.autoconfigure.AutoConfigurationPackages$Registrar
 * 而注解@ConfigurationPropertiesScan又包含了子注解@EnableConfigurationProperties，
 *     注解@EnableConfigurationProperties注解import了  EnableConfigurationPropertiesRegistrar.class
 **/
@EnableDubbo
@SpringBootApplication
public class ApacheDubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboProviderApplication.class, args);
    }
}

package com.cn.config;

import com.alibaba.dubbo.config.*;
import com.cn.service.boot.alibabadubbo.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-05 10:24
 **/
@Configuration
public class MyDubboConfig {
    /**
     * 对应<dubbo:application name="dubbo-service-provider"></dubbo:application>
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-service-provider");
        return applicationConfig;
    }

    /**
     * 对应<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    /**
     * 对应<dubbo:protocol name="dubbo" port="20880"></dubbo:protocol>
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * <dubbo:service interface="com.cn.service.UserService" ref="userServiceImpl01" version="1.0.0">
     *     <dubbo:method name="getUserAddressList" timeout="3000" retries="3"></dubbo:method>
     * </dubbo:service>
     *
     * <bean id="userServiceImpl01" class="com.cn.service.impl.UserServiceImpl">
     * </bean>
     * 使用下面这种方式，service的实现类上也需要加@Service注解，因为启动类上用到了包扫描
     */
    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(3000);
        methodConfig.setRetries(3);
        List<MethodConfig> list = new ArrayList<>();
        list.add(methodConfig);
        //将Method的设置关联到service配置中
        serviceConfig.setMethods(list);

        return serviceConfig;
    }

    /**
     * xml中其他的配置都有对应的config的bean，都可以用@Bean方式配置进行注入，比如<dubbo:provider timeout="5000"></dubbo:provider>，
     * ProviderConfig providerConfig = new ProviderConfig();
     * providerConfig.setTimeout(5000);
     */
}

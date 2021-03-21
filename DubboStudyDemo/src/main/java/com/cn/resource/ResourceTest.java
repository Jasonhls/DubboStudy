package com.cn.resource;

import org.junit.Test;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.List;

public class ResourceTest {
    @Test
    public void test() {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:/application.properties");
        System.out.println(resource.exists());
    }

    /**
     * 测试读取配置文件
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:/application.properties");
        PropertiesPropertySourceLoader sourceLoader = new PropertiesPropertySourceLoader();
        String name = "applicationConfig:['classpath:/application.properties']";
        List<PropertySource<?>> load = sourceLoader.load(name, resource);
        System.out.println(load);
    }
}

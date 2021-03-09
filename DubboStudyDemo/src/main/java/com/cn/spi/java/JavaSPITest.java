package com.cn.spi.java;

import java.util.ServiceLoader;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:12
 **/
public class JavaSPITest {
    public static void main(String[] args) {
        /**
         * ServiceLoader 会加载META-INF/services 接口实现类的全限定名配置在文件中，
         * 并由服务器加载读取配置文件，加载实现类
         */
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}

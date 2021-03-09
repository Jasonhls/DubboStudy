package com.cn.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:22
 **/
public class DubboSPITest {
    public static void main(String[] args) {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        /**
         * dubbo SPI支持默认设计
         * 配置 {@link org.apache.dubbo.common.extension.SPI}的value属性即可，即需要在Robot类上注解@SPI中配置value值
         * 获取默认的扩展类
         */
        Robot bumblebee = extensionLoader.getDefaultExtension();
        bumblebee.sayHello();
    }
}

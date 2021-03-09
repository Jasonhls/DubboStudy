package com.cn.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:45
 **/
public class DubboSPIAopTest {
    public static void main(String[] args) {
        /**
         * dubbo spi 在加载扩展点时，如果加载到的扩展点有拷贝构造函数，则判定为扩展点 Wrapper 类。
         * Wrapper 类有些类似 AOP，即 Wrapper 代理了扩展点。
         */
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        System.out.println(optimusPrime.getClass());
    }
}

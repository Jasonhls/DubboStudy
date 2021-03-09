package com.cn.spi.dubbo;


/**
 * @description: 关于 dubbo spi aop 的使用
 * dubbo spi 在加载扩展点时，如果加载到的扩展点有拷贝构造函数，则判定为扩展点 Wrapper 类。
 * Wrapper 类有些类似 AOP，即 Wrapper 代理了扩展点。
 * @author: helisen
 * @create: 2021-03-09 15:41
 **/
public class RobotWrapper implements Robot {

    private Robot robot;

    public RobotWrapper(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void sayHello() {
        System.out.println("===========");
        System.out.println("before");
        System.out.println("===========");
        robot.sayHello();
        System.out.println("===========");
        System.out.println("after");
        System.out.println("===========");
    }
}

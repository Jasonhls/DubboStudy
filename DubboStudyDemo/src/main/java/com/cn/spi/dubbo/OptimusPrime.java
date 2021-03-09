package com.cn.spi.dubbo;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:20
 **/
public class OptimusPrime implements Robot{
    @Override
    public void sayHello() {
        System.out.println("hello , I am Optimus Prime.");
    }
}

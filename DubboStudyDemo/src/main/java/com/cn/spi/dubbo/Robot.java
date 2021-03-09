package com.cn.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:20
 * @SPI中的value表示默认的扩展类，如果没有配置value，就没有默认的扩展类
 **/
@SPI(value = "bumblebee")
public interface Robot {
    /**
     * 测试接口
     */
    void sayHello();
}

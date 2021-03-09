package com.cn.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 15:20
 * @SPI中的value表示默认的扩展类，如果没有配置value，就没有默认的扩展类，
 * 这里配置value为true也相当于没有配置默认扩展类，具体源码可以看dubbo的ExtensionLoader类的getDefaultExtension()方法
 **/
@SPI(value = "bumblebee")
public interface Robot {
    /**
     * 测试接口
     */
    void sayHello();
}

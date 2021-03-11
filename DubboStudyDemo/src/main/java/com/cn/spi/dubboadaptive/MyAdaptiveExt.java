package com.cn.spi.dubboadaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:06
 **/
@SPI
public interface MyAdaptiveExt {
    @Adaptive(value = "myAdaptiveName")
    String echo(String msg, URL url);
}

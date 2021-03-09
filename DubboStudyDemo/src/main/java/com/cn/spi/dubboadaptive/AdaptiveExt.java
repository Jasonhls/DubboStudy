package com.cn.spi.dubboadaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface AdaptiveExt {
//    @Adaptive
    @Adaptive(value = {"myAdaptiveName"})//配置@Adaptive注解的value
    String echo(String msg, URL url);
}

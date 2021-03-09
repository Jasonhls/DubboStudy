package com.cn.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 18:20
 **/
@SPI
public interface AdaptiveExt {
    String echo(String msg, URL url);
}

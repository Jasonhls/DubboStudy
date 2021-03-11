package com.cn.spi.activate;

import org.apache.dubbo.common.extension.SPI;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:17
 **/
@SPI
public interface ActivateExt {
    String echo(String msg);
}

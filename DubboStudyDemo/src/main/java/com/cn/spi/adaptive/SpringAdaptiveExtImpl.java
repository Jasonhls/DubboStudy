package com.cn.spi.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 18:21
 **/
public class SpringAdaptiveExtImpl implements AdaptiveExt{
    @Override
    public String echo(String msg, URL url) {
        return "spring";
    }
}

package com.cn.spi.dubboadaptive;

import org.apache.dubbo.common.URL;

public class SpringBootAdaptiveExtImpl implements AdaptiveExt{
    @Override
    public String echo(String msg, URL url) {
        return "spring boot";
    }
}

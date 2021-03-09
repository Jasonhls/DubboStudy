package com.cn.spi.dubboadaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

@Adaptive
public class DubboAdaptiveExtImpl implements AdaptiveExt{
    @Override
    public String echo(String msg, URL url) {
        return "dubbo";
    }
}

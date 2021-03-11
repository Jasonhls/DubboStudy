package com.cn.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:28
 **/
@Activate(order = 1, group = {"order"})
public class OrderActivateExtImplMore implements ActivateExt{
    @Override
    public String echo(String msg) {
        return msg;
    }
}

package com.cn.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:19
 **/
@Activate(order = 2, group = {"order"})
public class OrderActivateExtImpl implements ActivateExt{

    @Override
    public String echo(String msg) {
        return null;
    }
}

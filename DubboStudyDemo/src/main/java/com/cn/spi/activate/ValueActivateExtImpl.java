package com.cn.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:29
 **/
@Activate(value = {"myKey"}, group = {"value"})
public class ValueActivateExtImpl implements ActivateExt{
    @Override
    public String echo(String msg) {
        return msg;
    }
}

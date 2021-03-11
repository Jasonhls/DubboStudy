package com.cn.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:18
 **/
@Activate(group = {"default_group"})
public class DefaultActivateExtImpl implements ActivateExt{
    @Override
    public String echo(String msg) {
        return msg;
    }
}

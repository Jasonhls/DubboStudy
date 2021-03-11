package com.cn.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:30
 **/
@Activate(group = {"group1", "default_group"})
public class GroupActivateExtImpl implements ActivateExt{
    @Override
    public String echo(String msg) {
        return msg;
    }
}

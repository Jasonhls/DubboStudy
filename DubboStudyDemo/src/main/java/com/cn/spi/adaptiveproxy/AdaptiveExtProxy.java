package com.cn.spi.adaptiveproxy;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 18:21
 **/
public class AdaptiveExtProxy implements AdaptiveExt{
    /**
     * AdaptiveExtProxy其实是一个代理类
     *  AdaptiveExtProxy所代理的对象是在echo方法中通过SPI加载得到的，
     *  echo方法主要做了三件事情：
     *  1）从 URL 中获取 AdaptiveExt 名称
     *  2）通过 SPI 加载具体的 AdaptiveExt 实现类
     *  3）调用目标方法
     */
    @Override
    public String echo(String msg, URL url) {
        if(url == null) {
            throw new IllegalArgumentException("url == null");
        }

        //1.从URL中获取 AdaptiveExt 名称
        String name = url.getParameter("adaptiveproxy.ext");
        if(name == null) {
            throw new IllegalArgumentException("name == null");
        }

        // 2.调用SPI动态加载具体的AdaptiveExt
        AdaptiveExt adaptiveExt = ExtensionLoader.getExtensionLoader(AdaptiveExt.class)
                .getExtension(name);
        //3.调用具体的方法
        return adaptiveExt.echo(msg, url);
    }
}

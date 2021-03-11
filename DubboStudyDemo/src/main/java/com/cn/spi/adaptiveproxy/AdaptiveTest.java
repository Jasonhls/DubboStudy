package com.cn.spi.adaptiveproxy;

import org.apache.dubbo.common.URL;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 18:26
 **/
public class AdaptiveTest {
    public static void main(String[] args) {
        /**
         * 测试dubbo的自适应拓展机制
         */
        URL url = URL.valueOf("test://localhost/test?adaptiveproxy.ext=spring");
        AdaptiveExt adaptiveExt = new AdaptiveExtProxy();
        System.out.println(adaptiveExt.echo("e", url));
    }
}

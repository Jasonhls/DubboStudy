package com.cn.spi.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-09 18:26
 **/
public class AdaptiveTest {
    public static void main(String[] args) {
        URL url = URL.valueOf("test://localhost/test?adaptive.ext=spring");
        AdaptiveExt adaptiveExt = new AdaptiveExtProxy();
        System.out.println(adaptiveExt.echo("e", url));
    }
}

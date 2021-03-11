package com.cn.spi.activate;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-11 17:51
 **/
public class ActivateTest {
    @Test
    public void testGroup() {
        ExtensionLoader<ActivateExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");

        List<ActivateExt> list = extExtensionLoader.getActivateExtension(url, new String[]{}, "default_group");
        list.forEach(a -> System.out.println(a.echo(a.getClass().getName())));
    }
}

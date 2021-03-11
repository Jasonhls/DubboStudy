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

    /**
     * 命中了Activate注解group为default_group的扩展点实例
     */
    @Test
    public void testGroup() {
        ExtensionLoader<ActivateExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");

        List<ActivateExt> list = extExtensionLoader.getActivateExtension(url, new String[]{}, "default_group");
        list.forEach(a -> System.out.println(a.echo(a.getClass().getName())));
    }

    /**
     * 命中了Activate注解group为value，且value为myKey的扩展点实例
     */
    @Test
    public void testValue() {
        ExtensionLoader<ActivateExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");
        /**
         * 对应@Activate(value = {"myKey"})
         */
        url = url.addParameter("myKey", "test");
        List<ActivateExt> list = extExtensionLoader.getActivateExtension(url, new String[] {}, "value");
        list.forEach(a -> System.out.println(a.echo(a.getClass().getName())));
    }

    /**
     * 命中了Activate注解group为order的扩展点实例，且order低的优先级高
     */
    @Test
    public void testOrder() {
        ExtensionLoader<ActivateExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");
        List<ActivateExt> list = extExtensionLoader.getActivateExtension(url, new String[] {}, "order");
        list.forEach(a -> System.out.println(a.echo(a.getClass().getName())));
    }
}

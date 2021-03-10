package com.cn.spi.dubboadaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.utils.StringUtils;
import org.junit.Test;

public class DubboAdaptiveTest {
    @Test
    public void testOne() {
        ExtensionLoader<AdaptiveExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);
        AdaptiveExt adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext=spring");
        System.out.println(adaptiveExt.echo("d", url));
    }

    /**
     * 注解@Adaptive直接用到方法上，value值与链接中的key一致，链接中的key对应的value就是spi中的name，获取相应的实现类。
     */
    @Test
    public void testTwo() {
        ExtensionLoader<AdaptiveExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);
        AdaptiveExt adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        //@Adaptive注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name，获取相应的实现类。
        URL url = URL.valueOf("test://localhost/test?myAdaptiveName=springboot");
        System.out.println(adaptiveExt.echo("d", url));
    }

    /**
     * 如果有实现类上有@Adaptive注解，会默认调用该类进行调用
     */
    @Test
    public void testThree() {
        ExtensionLoader<AdaptiveExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);
        AdaptiveExt adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?myAdaptiveName=spring");
        //即使上面的url中myAdaptiveName=spring，但是DubboAdaptiveExtImpl类上配置了注解@Adaptive，因此会优先调用该类。
        System.out.println(adaptiveExt.echo("d", url));
    }

    @Test
    public void testFour() {
        Class type = AdaptiveExt.class;
        // AdaptiveExt
        System.out.println(type.getSimpleName());
        String splitName = StringUtils.camelToSplitName(type.getSimpleName(), ".");
        // adaptive.ext
        System.out.println(splitName);
    }

}

package com.cn.wrapper;

import org.apache.dubbo.common.bytecode.Wrapper;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-18 18:24
 **/
public class WrapperTest {
    @Test
    public void testWrapper() throws InvocationTargetException {
        final Wrapper wrapper = Wrapper.getWrapper(new MyClass().getClass());
        //invokeMethod，第一个参数为对象，第二个参数为方法名，第三个参数为方法参数类型集合，第四个为传入的参数值集合
        wrapper.invokeMethod(new MyClass(), "say", new Class[] {String.class}, new String[] {"yes"});
    }
}

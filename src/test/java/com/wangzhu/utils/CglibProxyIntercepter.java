package com.wangzhu.utils;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wang.zhu on 2021-05-26 18:31.
 **/
public class CglibProxyIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始---");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("结束---");
        return obj;
    }
}

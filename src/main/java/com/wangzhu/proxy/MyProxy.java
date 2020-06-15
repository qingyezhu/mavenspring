package com.wangzhu.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by wang.zhu on 2020-06-15 20:43.
 **/
public class MyProxy implements InvocationHandler, FactoryBean<Object> {

    private Class<?> clazz;

    public MyProxy(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Object getObject() {
        return Proxy.newProxyInstance(MyProxy.class.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("toString")){
            return proxy.getClass().toString();
        }
        return Arrays.toString(args);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}

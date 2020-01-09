package com.wangzhu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wang.zhu on 2020-01-09 14:21.
 **/
public class MessageProxy implements InvocationHandler {

    public IMessageTest bind() {
        return (IMessageTest) Proxy.newProxyInstance(MessageProxy.class.getClassLoader(), new Class[]{IMessageTest.class}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "haah" + System.currentTimeMillis();
    }
}

package com.wangzhu.proxy;

import com.wangzhu.spring.beanannotation.injection.service.InjectionService;
import com.wangzhu.utils.ReflectionUtil;

/**
 * Created by wang.zhu on 2020-01-09 14:25.
 **/
public class MessageTestMain {

    public static void main(String[] args) {

        System.out.println(ReflectionUtil.getMethods(MessageProxy.class));
        System.out.println(ReflectionUtil.getMethods(InjectionService.class));

        Class<?> clazz = IMessageTest.class;
        IMessageTest messageTest = new MessageProxy().bind();

        System.out.println(messageTest);

        System.out.println(clazz.isInterface());

        System.out.println(clazz.isInstance(messageTest));


    }
}

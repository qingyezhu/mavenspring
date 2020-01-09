package com.wangzhu.proxy;

/**
 * Created by wang.zhu on 2020-01-09 14:25.
 **/
public class MessageTestMain {

    public static void main(String[] args) {


        Class<?> clazz = IMessageTest.class;
        IMessageTest messageTest = new MessageProxy().bind();

        System.out.println(messageTest);

        System.out.println(clazz.isInterface());

        System.out.println(clazz.isInstance(messageTest));


    }
}

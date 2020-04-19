package com.wangzhu.other;

/**
 * Created by wang.zhu on 2020-04-16 10:12.
 **/
public class Static1 {
    /**
     * 静态变量外部使用前，先初始化内部静态块
     */
    public static int a = 1;
    public static final int b = 2;

    static {
        System.out.println("静态块初始化 " + System.currentTimeMillis());
    }

    /**
     * 静态方法被调用前，先初始化内部静态块
     */
    public static void init(){
        System.out.println("静态方法调用 " + System.currentTimeMillis());
    }

    static class InnerStatic1{
        public static int innerA = 3;
        public final static int innerB = 4;
        static{
            System.out.println("内部静态块初始化 " + System.currentTimeMillis());
        }

        public static void innerInit(){
            System.out.println("内部静态方法调用 " + System.currentTimeMillis());
        }
    }
}

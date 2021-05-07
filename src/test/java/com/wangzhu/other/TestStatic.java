package com.wangzhu.other;

/**
 * Created by wang.zhu on 2020-04-16 10:11.
 **/
public class TestStatic {

//    static int c = 5;
//    final static int d = 6;
//
//    static{
//        System.out.println("静态块初始化 " + System.currentTimeMillis());
//    }
//
//
//    static class InnerTestStatic{
//        static int e = 7;
//        final static int f = 8;
//
//        static{
//            System.out.println("内部静态块初始化 " + System.currentTimeMillis());
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(Static1.b);//常量
//        System.out.println(Static1.a);

//        Static1.init();

        System.out.println(Static1.InnerStatic1.innerB);//常量
//        System.out.println(Static1.InnerStatic1.innerA);

        Static1.InnerStatic1.innerInit();

        //这种测试，是有问题的
//        System.out.println(TestStatic.c);
//        System.out.println(TestStatic.d);

//        System.out.println(InnerTestStatic.e);
//        System.out.println(InnerTestStatic.f);
    }
}

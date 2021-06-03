package com.wangzhu.other;

/**
 * Created by wang.zhu on 2021-05-26 22:28.
 **/
public class ClassTest {
    public static void main(String[] args) throws Exception {
//        final String str = "com.wangzhu.other.bean.Animal";
        final String str = "com.wangzhu.other.bean.Dog";
//        Class<?> clazz = Class.forName(str);
//        System.out.println(clazz);

        final MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> cl = myClassLoader.loadClass(str);
        System.out.println(cl);

    }
}

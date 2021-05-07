package com.wangzhu.utils;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by wang.zhu on 2021-04-26 18:21.
 **/
public class TestStringNew {
    public static void main(String[] args) {
        String s1 = "hello";
        //final String s1 = "hello";
        String s2 = "world";
        //final String s2 = "world";

        final String s3 = s1 + s2;

        System.out.println(s3);


        System.out.println(ClassLayout.parseInstance(s3).toPrintable());

        final Person person = new Person();
        person.print();
    }


    int method(int a,int b, int c){
        return 0;
    }

    String method(int c,int d){
        return "";
    }
}

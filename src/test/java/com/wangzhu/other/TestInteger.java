package com.wangzhu.other;

/**
 * Created by wang.zhu on 2020-02-19 11:22.
 **/
public class TestInteger {

    public static void main(String[] args) {
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//
//        System.out.println(c == d); //true
//        System.out.println(e == f); //false
//        System.out.println(c == (a + b)); //true
//        System.out.println(c.equals(a + b)); //true
//        System.out.println(g == (a + b)); //true
//        System.out.println(g.equals(a + b)); //false

        int a = 1;
        a++;
        System.out.println(a);
        int b = a++;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
        int c = ++a;
//        System.out.println("a = " + a);
//        System.out.println("c = " + c);
        a = a++;
//        System.out.println("a = " + a);
        a = ++a;


        Integer i = 1;
                i++;
        System.out.println(i);
    }

}

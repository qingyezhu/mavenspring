package com.wangzhu.tmp;

import java.util.List;

/**
 * Created by wang.zhu on 2020-09-29 10:57.
 **/
public class SynchronizedTest {

    public synchronized void method1() throws Exception {
        System.out.println("method1 start");
        Thread.sleep(1000);
        System.out.println("method1 end");
    }

    public synchronized void method2() throws Exception {
        System.out.println("method2 start");
        Thread.sleep(1000);
        System.out.println("method2 end");
    }

    public synchronized static void method3() throws Exception {
        System.out.println("method3 start");
        Thread.sleep(1000);
        System.out.println("method3 end");
    }

    public synchronized static void method4() throws Exception {
        System.out.println("method4 start");
        Thread.sleep(1000);
        System.out.println("method4 end");
    }

    public void method5() throws Exception {
        System.out.println("method5 start");
        Thread.sleep(1000);
        System.out.println("method5 end");
    }

    public static void method6() throws Exception {
        System.out.println("method6 start");
        Thread.sleep(1000);
        System.out.println("method6 end");
    }

    public Integer findMaxItem(final List<Integer> list) {

        return null;
    }

    public String toBinaryString(int num){
        return null;
    }

    public boolean isEven(int num){
        return true;
    }


    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        Integer d = new Integer(1);
        Integer e = 300;
        Integer f = 300;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);

    }


}

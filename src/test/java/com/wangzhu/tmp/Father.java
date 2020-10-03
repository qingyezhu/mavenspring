package com.wangzhu.tmp;

/**
 * Created by wang.zhu on 2020-09-29 10:20.
 **/
public class Father {

    private int i = test();

    {
        System.out.print("(1)");
    }

    private static int j = method();

    static {
        System.out.print("(2)");
    }

    Father() {
        System.out.print("(3)");
    }

    public int test() {
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 2;
    }

    public int getI() {
        return i;
    }

    public static int getJ() {
        return j;
    }
}

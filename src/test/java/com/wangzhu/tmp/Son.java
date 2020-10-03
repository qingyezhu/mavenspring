package com.wangzhu.tmp;

/**
 * Created by wang.zhu on 2020-09-29 10:21.
 **/
public class Son extends Father {
    private int i = test();

    static {
        System.out.print("(6)");
    }

    private static int j = method();

    Son() {
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 3;
    }

    public static int method() {
        System.out.print("(10)");
        return 4;
    }

    @Override
    public int getI() {
        return i;
    }

    public static int getJ() {
        return j;
    }
}

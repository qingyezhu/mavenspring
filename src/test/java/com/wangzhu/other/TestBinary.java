package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wang.zhu on 2020-05-16 10:56.
 **/
public class TestBinary {

    @Test
    public void test1() {
        int b = -100;
        System.out.println(Integer.toBinaryString(b));
        for (int i = 1; i < 35; i++) {
            System.out.println(i + "==" + (b << i) + "==" + Integer.toBinaryString(b << i));
        }
    }
}

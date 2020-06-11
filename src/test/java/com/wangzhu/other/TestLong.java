package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wang.zhu on 2020-04-19 15:36.
 **/
public class TestLong {

    @Test
    public void test(){

        final int i = 1;
        final long l = i;
        final float f = (float)l;

        System.out.println(f);
    }
}

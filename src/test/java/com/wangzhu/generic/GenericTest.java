package com.wangzhu.generic;

import org.junit.Test;

/**
 * Created by wang.zhu on 2020-05-27 11:01.
 **/
public class GenericTest {

    @Test
    public void testA(){
        final AbstractServiceA a = new ServiceA();
        a.init();
    }

    @Test
    public void testB(){
        final IServiceB b = new ServiceB();
        b.init();
    }

    @Test
    public void testC(){
        final IServiceC c = new ServiceC();
        c.init();
    }

    @Test
    public void testBV2(){
        final IServiceB bV2 = new ServiceBV2();
        bV2.init();
    }
}

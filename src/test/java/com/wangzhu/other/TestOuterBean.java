package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wang.zhu on 2021-03-09 18:25.
 **/
public class TestOuterBean {

    @Test
    public void testA() {
        //静态内部类
        final OuterClassBean.A a = new OuterClassBean.A();
        a.innerMethod();
        OuterClassBean.A.innerStaticMethod();
    }

    @Test
    public void testB() {
        final OuterClassBean outerClassBean = new OuterClassBean();
        final OuterClassBean.B b = outerClassBean.new B();
        b.innerMethod();
//        b.innerStaticMethod();
    }
}

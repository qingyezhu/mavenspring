package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wang.zhu on 2021-03-10 00:17.
 **/
public class TestException {

    private int getResult() throws Exception {
        int a = 100;
        try {
            a = a + 10;
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("截获异常并重新抛出异常");
            throw new Exception();
        } finally {
            return a;
        }
    }

    @Test
    public void test1() {
        try {
            System.out.println(getResult());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("截获异常catch");
        } finally {
            System.out.println("异常处理finally");
        }
    }
}

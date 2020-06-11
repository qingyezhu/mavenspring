package com.wangzhu.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang.zhu on 2020-05-10 09:30.
 **/
public class TestBoolean {
    boolean flag = false;
    boolean simpleBoolean = false;
    Boolean objectBoolean = Boolean.FALSE;

    public void test1() {
        final Boolean b1 = flag ? objectBoolean : objectBoolean;
    }

    public void test2() {
        final boolean b2 = flag ? simpleBoolean : simpleBoolean;
    }

    public void test3() {
        final boolean b3 = flag ? objectBoolean : objectBoolean;
    }

    public void test4() {
        final Boolean b4 = flag ? simpleBoolean : simpleBoolean;
    }

    public void test5() {
        final Boolean b5 = flag ? objectBoolean : simpleBoolean;
    }

    public void test6() {
        final boolean b6 = flag ? objectBoolean : simpleBoolean;
    }

    public void test7(){
        final Map<String, Boolean> map = new HashMap<>();
        final boolean b71 = map != null ? map.get("a") : false;

        //jdk8+ 不一样 引用类型
        final Boolean b72 = map != null ? map.get("a") : false;
    }
}

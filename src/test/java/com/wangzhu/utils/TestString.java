package com.wangzhu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestString {
    private static final Logger logger = LoggerFactory.getLogger(TestString.class);

    @Test
    public void test1() {
        String str1 = "hello";
        String str2 = "hello";
        //常量池中同一个引用 true
        logger.info("{}", str1 == str2);
    }

    @Test
    public void test2() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        //new 出来的，分别是堆中的新对象 false
        logger.info("{}", str1 == str2);
    }

    @Test
    public void test3() {
        String str1 = new String("hello");
        String str2 = new String("hello");

        //intern是去常量池获取字符串常量 true
        logger.info("{}", str1.intern() == str2.intern());
    }

    @Test
    public void test4() {
        String str1 = "hello";
        String str2 = new String("hello");

        //字符串常量，常量池中存的就是这个，故intern就是此引用 true
        logger.info("{}", str1 == str2.intern());
    }

    @Test
    public void test5() {
        String str1 = new String("hello");
        String str2 = "hello";

        //字符串常量，常量池中存的就是这个，故intern就是此引用 true
        logger.info("{}", str1.intern() == str2);
    }

    @Test
    public void test6() {
        String str1 = "hello";
        String str2 = new String(str1);

        //常量池中的引用，intern自然获取到是str1的引用 true
        logger.info("{}", str1 == str2.intern());
    }

    @Test
    public void test7() {
        String str1 = new String("hello") + new String("world");
        String str2 = "helloworld";

        //new出来是新对象 false
        logger.info("{}", str1 == str2);
    }

    @Test
    public void test8() {
        String str1 = new String("hello") + new String("world");
        String str2 = "helloworld";

        //str2是常量池中的引用，intern的是常量池中的引用 true
        logger.info("{}", str1.intern() == str2);
    }

    @Test
    public void test9() {
        String str1 = "helloworld";
        String str2 = new String("hello") + new String("world");

        //str1是常量池中的引用，intern是常量池中的引用 true
        logger.info("{}", str1 == str2.intern());
    }

    @Test
    public void test10() {
        String str1 = new String("hello") + new String("world");

        //常量池中本身没有，故intern后就是同原来的引用 true
//        logger.info("{}", str1 == str1.intern());
        logger.info("{}", str1.intern() == str1);
    }

    @Test
    public void test11() {
        String str1 = new String("hello") + new String("world");
        //常量池中本来没有，故intern后就用new出来的引用 true
        logger.info("{}", str1.intern() == str1);

        String str2 = new String("hello") + new String("world");
        //常量池中已经有了 false
        logger.info("{}", str2.intern() == str2);

        //intern是常量池中的 true
        logger.info("{}", str2.intern() == str1);
    }

    @Test
    public void test12() {
        String str1 = "hello" + "world";
        String str2 = "helloworld";

        //编译期间就会替换为常量 true
        logger.info("{}", str1 == str2);

        String temp = "hello";
        String str3 = temp + "world";
        String str4 = "helloworld";
        //局部变量编译期无法确定，故是创建新对象 false
        logger.info("{}", str3 == str4);
    }

    @Test
    public void test13() {
        String str = null;
        switch (str) {
            case "1":
                System.out.println("1");
                break;
            case "a":
                System.out.println("a");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}

package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wang.zhu on 2021-03-03 10:02.
 **/
public class SwitchTest {

    enum TestSwitchEnum {
        A(1, "a"), B(2, "b"), C(3, "c");

        private final int s;
        private final String d;

        TestSwitchEnum(final int s, final String d) {
            this.s = s;
            this.d = d;
        }

    }

    @Test
    public void testEnum() {
        TestSwitchEnum testSwitchEnum = TestSwitchEnum.B;
        switch (testSwitchEnum) {
            case C:
                System.out.println("C");
                break;
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            default:
                System.out.println("default: " + testSwitchEnum);
                break;
        }
    }

    @Test
    public void testCharacter() {
        Character b = 1;

        switch (b) {
            case 'a':
                System.out.println("122");
                break;
            case '1':
                System.out.println("65535");
                break;
            default:
                System.out.println("default: " + b);
                break;
        }
    }

    @Test
    public void testByte() {
        Byte b = 1;

        switch (b) {
            case 122:
                System.out.println("122");
                break;
            case -18:
                System.out.println("-18");
                break;
            default:
                System.out.println("default: " + b);
                break;
        }
    }

    @Test
    public void testShort() {
        Short b = 1;

        switch (b) {
            case 128:
                System.out.println("122");
                break;
            case -18:
                System.out.println("-18");
                break;
            case 32767:
                System.out.println("32767");
                break;
            default:
                System.out.println("default: " + b);
                break;
        }
    }

    @Test
    public void testInt() {
        Integer a = 1;

        switch (a) {
            case 2:
                System.out.println("2");
                break;
            case 5:
                System.out.println("5");
                break;
            case 1:
                System.out.println("1");
                break;
            case 11:
                System.out.println("11");
                break;
            case -1:
                System.out.println("-1");
                break;
            default:
                System.out.println("default: " + a);
                break;
        }
    }

    @Test
    public void testString() {
        String str = "hello";

        switch (str) {
            case "a":
                System.out.println("a");
                break;
            case "11":
                System.out.println("11");
                break;
            case "wor11":
                System.out.println("wor11");
                break;
            case "!@#":
                System.out.println("!@#");
                break;
            case "hello":
                System.out.println("hello");
                break;
            default:
                System.out.println("default: " + str);
                break;
        }
    }
}

package com.wangzhu.other;

import org.junit.Test;

/**
 * Created by wangz on 2024/7/24 11:49.
 **/
public class TestAutoBoxingAndAutoUnBoxing {

    @Test
    public void testByte() {
        byte b1 = 1;
        byte b2 = 127;
        byte b3 = (byte) 128;
        byte b31 = (byte) 129;
        byte b4 = -1;
        byte b5 = -127;
        byte b6 = -128;
        byte b7 = (byte) -129;
        byte b71 = (byte) -130;

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        System.out.println("b31: " + b31);
        System.out.println("b4: " + b4);
        System.out.println("b5: " + b5);
        System.out.println("b6: " + b6);
        System.out.println("b7: " + b7);
        System.out.println("b71: " + b71);

        Byte B1 = 1;
        Byte B2 = 127;
        Byte B3 = (byte)128;
        Byte B31 = (byte)129;
        Byte B4 = -1;
        Byte B5 = -127;
        Byte B6 = -128;
        Byte B7 = (byte)-129;
        Byte B71 = (byte)-130;
        System.out.println("B1: " + B1);
        System.out.println("B2: " + B2);
        System.out.println("B3: " + B3);
        System.out.println("B31: " + B31);
        System.out.println("B4: " + B4);
        System.out.println("B5: " + B5);
        System.out.println("B6: " + B6);
        System.out.println("B7: " + B7);
        System.out.println("B71: " + B71);

        byte bb3 = B3;
        byte bb31 = B31;
        byte bb7 = B7;
        byte bb71 = B71;

        System.out.println("bb3: " + bb3);
        System.out.println("bb31: " + bb31);
        System.out.println("bb7: " + bb7);
        System.out.println("bb71: " + bb71);
    }

    @Test
    public void testChar(){
        char c0 = 0;
        char c1 = 1;
        char c2 = (char)-1;
        char c3 = 65535;
        char c4 = (char)65536;
        char c5 = (char)65537;

        Character C1 = c1;
        Character C2 = c2;
        Character C3 = c3;
        Character C4 = c4;
        Character C5 = c5;

        char cc1 = C1;
        char cc3 = C3;
        char cc5 = C5;

    }
}

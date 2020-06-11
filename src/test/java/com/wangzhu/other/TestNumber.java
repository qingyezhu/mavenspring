package com.wangzhu.other;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by wang.zhu on 2020-04-28 00:01.
 **/
public class TestNumber {

    @Test
    public void testFloat() {
        final float a = 0.125f, b = 0.125f;
        System.out.println(a - b);
    }

    @Test
    public void testDouble() {
        final double a = 0.125d, b = 0.125d;
        System.out.println((a - b));
    }


    @Test
    public void testFloat1() {
        final float a = 0.3f, b = 0.2f, c = 0.1f;
        System.out.println((a - b) + "==" + (b - c));
    }

    @Test
    public void testDouble1() {
        final double a = 0.3d, b = 0.2d, c = 0.1d;
        System.out.println((a - b) + "==" + (b - c));
    }

    @Test
    public void testFloat2() {
        final float a = 0.125f;
        final double b = 0.125d;
        System.out.println(a - b == 0);
    }

    private void print(float f){
        System.out.println(f);
    }

    private void print(double d){
        System.out.println(d);
    }

    private void print(Object object){
        System.out.println("object");
    }

    private void print(List list){
        System.out.println("list");
    }

    private void print(Collection collection){
        System.out.println("collection");
    }

    private void print(Set set){
        System.out.println("set");
    }

    @Test
    public void testOverLoad(){
        Collection collection = null;
        print(collection);
        Set set = null;
        print(set);
        List list = null;
        print(list);
    }

    @Test
    public void testDouble3(){
        final double d = 0.9d - 0.8d;
        System.out.println(d + "");
        System.out.println(String.valueOf(d));
        final BigDecimal bd = new BigDecimal(d + "");
        System.out.println(bd);
    }

    @Test
    public void test1(){
        int i = 1;
        int a = i ++;
        int b = ++i;
        System.out.println(a);
        System.out.println(b);
    }
}

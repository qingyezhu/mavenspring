package com.wangzhu.other;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wang.zhu on 2020-05-10 18:39.
 **/
public class TestMap {

    @Test
    public void test1() {
        final Map<String, Integer> map = new HashMap<>(16);
        print(map);
        map.put("a", 1);
        print(map);
        map.put("b", 1);
        print(map);
    }

    private void print(final Map<String, Integer> map) {
        System.out.println("-----before-----");
        printMethod(map, "capacity");
        printField(map, "size");
        printField(map, "loadFactor");
        printField(map, "threshold");
        System.out.println("-----after-----");
        System.out.println();
        System.out.println();
    }

    private void printMethod(final Map<String, Integer> map, final String methodName) {
        try {
            final Class<?> clazz = map.getClass();

            final Method method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(Boolean.TRUE);
            System.out.println(methodName + "----" + method.invoke(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <K,V> void printField(final Map<K, V> map, final String fieldName){
        try {
            final Class<?> clazz = map.getClass();
            final Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(Boolean.TRUE);
            System.out.println(fieldName + "----" + field.get(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        int n = 9;
        n |= n >>> 1;
        System.out.println(n);
    }

    @Test
    public void test3(){
        final Map<Integer, Integer> map = new ConcurrentHashMap<>();
        //printField(map, "table");
        for(int i = 0;i < 1000;i ++){
            map.put(i, i);
        }
        map.put(1223, 1223);
    }
}

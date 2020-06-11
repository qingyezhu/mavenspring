package com.wangzhu.other;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wang.zhu on 2020-04-21 11:51.
 **/
public class TestList {

    public static void main(String[] args) {
        test(0, 1000000);
        test(0, 1000000);
        test(1000000, 2000000);
        test(1000000, 2000000);
    }


    private static void test(final int start, final int end) {
        final long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        final long endTime = System.currentTimeMillis();
        System.out.println(start + "-" + end + "=" + (endTime - startTime));
    }


    @Test
    public void testRemove() {
        final List<String> list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");

        final CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);

        System.out.println("before: " + list);

//        for (int i = 0, size = list.size(); i < size; i++) {
        for (int i = 0; i < list.size(); i++) {
            final String item = list.get(i);
            if ("11".equals(item)) {
                System.out.println(list.remove(i));
            }
            if ("12".equals(item)) {
                System.out.println(list.remove(i));
            }
        }
        System.out.println("after: " + list);

        System.out.println("before: " + copyOnWriteArrayList);
//        for (int i = 0, size = copyOnWriteArrayList.size(); i < size; i++) {
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            final String item = copyOnWriteArrayList.get(i);
            if ("11".equals(item)) {
                System.out.println(copyOnWriteArrayList.remove(i));
            }
        }
        System.out.println("after: " + copyOnWriteArrayList);
    }

    @Test
    public void test2() {
        final int[] arr = {11, 2, 3, 44};
        System.out.println(Arrays.asList(arr).size());
        System.out.println(Lists.newArrayList(arr).size());
    }

    @Test
    public void test3() {
        final List<Integer> list = new ArrayList<>();

        final int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        final BitSet removeSet = new BitSet(size);

        for (int i = 0; i < size; i++) {
            if ((i & 1) == 0) {
                removeSet.set(i);
            }
        }

        for (int i = 0; i < size; i++) {
            int j = removeSet.nextClearBit(i);
            System.out.println(i + "===" + j);
        }
    }

    @Test
    public void test4() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (final String str : list) {
            System.out.println(str);
            if ("1".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list);
    }

    @Test
    public void test41() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        for (final String str : list) {
            System.out.println(str);
            if ("2".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list);
    }

    @Test
    public void test5() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        //倒数第二个没有异常，其他情况都有异常，cursor=6，size=6 hasNext过不去了
        for (final String str : list) {
            System.out.println(str);
            if ("6".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test51() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        //倒数第一个异常，cursor=7，size=6，hasNext过去了，next检测异常了
        //modCount != expectedModCount

        for (final String str : list) {
            System.out.println(str);
            if ("7".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test61() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        //正常 cursor=1，size=1
        for (final String str : list) {
            System.out.println(str);
            if ("1".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }


    @Test
    public void test62() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        //异常 cursor=2，size=1
        for (final String str : list) {
            System.out.println(str);
            if ("2".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test7(){
        final LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        blockingQueue.add("1");
        System.out.println(blockingQueue);
    }
}

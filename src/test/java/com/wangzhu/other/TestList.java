package com.wangzhu.other;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
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
    public void test7() {
        final LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        blockingQueue.add("1");
        System.out.println(blockingQueue);
    }


    @Test
    public void testArrayAsList() {
        //当成是一个元素了
        final int[] ints = {1, 2, 3, 4, 5};
        System.out.println(Arrays.asList(ints));

        final Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        final List<Integer> integerList = Arrays.asList(integers);
        System.out.println(integerList);
//        integerList.add(10);
    }

    @Test
    public void testArrayAsListToArray() {
        final Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        final List<Integer> integerList = Arrays.asList(integers);
        final Object[] objects1 = integerList.toArray();
        System.out.println(objects1.getClass());//Integer(jdk9之前)
        final Integer[] integers1 = (Integer[]) objects1;
        System.out.println(integers1);
        //ArrayStoreException 存储的是Integer类型，不能存储为String类型
//        objects1[0] = "string";
        //ArrayStoreException 本身就是Integer类型，不能copy到String类型数组
//        final Object[] objects = integerList.toArray(new String[0]);
        final Object[] objects2 = integerList.toArray(new Integer[0]);
        System.out.println(objects2.getClass());//Integer
        final Integer[] integers2 = (Integer[]) objects2;
        System.out.println(integers2);

        final Object[] objects3 = integerList.toArray(new Object[0]);
        System.out.println(objects3.getClass());//Object
        System.out.println(Arrays.toString(objects3));
        objects3[0] = 2;
        System.out.println(Arrays.toString(objects3));
        //ClassCastException
//        final Integer[] integers3 = (Integer[]) objects3;
//        System.out.println(integers3);
    }

    @Test
    public void testListToArray() {
        final List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        final Object[] objects1 = list.toArray();
        System.out.println(objects1.getClass());//Object
        System.out.println(Arrays.toString(objects1));
        objects1[0] = 1;
        System.out.println(Arrays.toString(objects1));
        //ClassCastException
//        final String[] strings1 = (String[]) objects1;
//        System.out.println(strings1.getClass());

        final Object[] objects2 = list.toArray(new String[0]);
        System.out.println(objects2.getClass());//String
        //ArrayStoreException
//        objects2[0] = 1;
        final String[] strings2 = (String[]) objects2;
        System.out.println(strings2.getClass());

        final Object[] objects3 = list.toArray(new Object[0]);
        System.out.println(objects3.getClass());//Object
        System.out.println(Arrays.toString(objects3));
        objects3[0] = 2;
        System.out.println(Arrays.toString(objects3));
        //ClassCastException
//        final String[] strings3 = (String[]) objects3;
//        System.out.println(strings3.getClass());
    }

    @Test
    public void testListToArrayV2() {
        final List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        final Object[] objects = list.toArray(new Object[0]);
        System.out.println(objects.getClass()); //Object
        objects[0] = 1;
        System.out.println(Arrays.toString(objects));

        //ClassCastException
//        final String[] strings = (String[]) objects;
//        System.out.println(strings);

        final Object[] strObjects = list.toArray(new String[0]);
        System.out.println(strObjects.getClass()); //String
        final String[] strings = (String[]) strObjects;
        System.out.println(strings.getClass()); //String
//        final Integer[] integers = list.toArray(new Integer[0]); //ArrayStoreException
        final Integer[] integers = list.toArray(new Integer[10]); //ArrayStoreException
    }

    interface MyInterface {
        int a = 1; //常量

        void aa();

        default void bb() {

        }

        static void cc() {

        }
    }

    @Test
    public void testT() {
        final List<Number> numberList = new ArrayList<>();

        final List<Integer> integerList = new ArrayList<>();
        final List<Long> longList = new ArrayList<>();
        final Integer integer = 1;
        final Number number = 2;

        //里面都是Number或Number的子类，故读取的元素都是Number或Number的子类，但没法添加元素（除了null）
        List<? extends Number> aa = numberList;
        aa = integerList;
        aa = longList;
        final Number bb = aa.get(0);
        final Object obj = aa.get(0);
//        aa.add(integer);
        aa.add(null);
//        aa.add(new Object());

        //里面是Number或Number的父类，故读取元素不确定是哪种类型的元素（当然都是Object类型的），但Number以及Number的子类可以写入
        final List<? super Number> cc = null;
        cc.add(number);
        cc.add(integer);
        cc.add(null);
//        cc.add(new Object());
//        final Number number1 = cc.get(0);
        final Object object = cc.get(0);

    }
}

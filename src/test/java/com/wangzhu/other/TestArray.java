package com.wangzhu.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wang.zhu on 2020-04-12 17:30.
 **/
public class TestArray {

    public static void main(String[] args) {

        final A<String> a = new A<String>() {
            @Override
            void print(List<String> list) {
                System.out.println(list);
            }
        };
        a.calc(Arrays.asList("a", "b", "c"));

        final B<Integer> b = new B<Integer>() {
            @Override
            void print(Object[] elements) {
                System.out.println(Arrays.toString(elements));
            }

            @Override
            void print1(Object... elements) {
                System.out.println(Arrays.toString(elements));
            }
        };

        b.calc(Arrays.asList(1, 2, 3));


        int[] arrInt = {1, 3, 5, 7, 9};
        final List<int[]> list = Arrays.asList(arrInt);
        System.out.println(list);

        printInt(arrInt);
        printInt(1);
        printInt(1, 2, 3);

        String[] arrStr = {"a", "b", "c", "d"};
        printStr(arrStr);
        printStr("a");
        printStr("a", "b", "c");

        print(arrInt);
        print(arrStr);
        print("a", "b", "c");
        print(1, 2, 3);
        print(1L, 2L, 3L);

        final C<Integer> c = new C<>();
        c.setName(1);

        final Number number = 1;
        final C<? extends Number> cc = new C<>();
//        cc.setName(number);
        System.out.println(cc.getName());

        final C<? super Number> ccc =new C<>();
        ccc.setName(number);
        System.out.println(ccc.getName());
    }

    static abstract class A<T> {
        void calc(final List<T> list) {
            final List<T> tmp = new ArrayList<>();
            tmp.add(list.get(0));
            print(tmp);
        }

        abstract void print(List<T> list);
    }

    static abstract class B<T> {
        void calc(final List<T> list) {
            print(list.get(0));
            int[] arr = {1, 3, 5, 7, 9};
            print1(arr);
        }

        abstract void print(Object... elements);

        abstract void print1(Object... elements);
    }

    static void printInt(int... arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void printStr(String... arr) {
        System.out.println(Arrays.toString(arr));
    }

    static <T> void print(T... arr) {
        System.out.println(Arrays.toString(arr));
    }

    static class C<T>{
        T name;

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }
    }
}

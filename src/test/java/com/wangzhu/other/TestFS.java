package com.wangzhu.other;

/**
 * Created by wang.zhu on 2020-02-17 15:44.
 **/
public class TestFS {
    class Father {
        private void a() {
            System.out.println("father a");
        }

        protected void b() {
            System.out.println("father b");
        }

        public void call() {
            a();
            b();
        }
    }

    class Son extends Father {
        public void a() {
            System.out.println("son a");
        }

        protected void b() {
            System.out.println("son b");
        }

        public void call() {
            a();
            b();
        }
    }

    public static void main(String[] args) {
        final TestFS testFS = new TestFS();
        final Father father = testFS.new Son();
        father.call();
    }
}

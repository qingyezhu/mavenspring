package com.wangzhu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wang.zhu on 2020-08-18 22:57.
 **/
public class LoopThreadTest {


    private final Object object = new Object();
    volatile int flag = 0;
    int index = 0;

    public static void main(String[] args) {
        final LoopThreadTest loopThreadTest = new LoopThreadTest();
        loopThreadTest.start();
//        loopThreadTest.startV2();
    }

    private void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ": " + (index++));
        }
    }

    private class MyThread extends Thread {

        int begin;
        int end;

        public MyThread(String name, int begin, int end) {
            super(name);
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            myThreadRun(begin, end);
        }
    }

    private void myThreadRun(final int begin, final int end) {
        synchronized (object) {
            while (flag != begin) {
                try {
                    object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            print();
            flag = end;
            object.notifyAll();
        }
    }

    private void start() {
        flag = 1;
        new MyThread("my-a", 1, 2).start();
        new MyThread("my-b", 2, 3).start();
        new MyThread("my-c", 3, 4).start();
    }

    class MyThreadV2 extends Thread {

        private int begin;
        private int end;

        public MyThreadV2(String name, int begin, int end) {
            super(name);
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            myThreadRunV2(begin, end);
        }
    }

    private void myThreadRunV2(final int begin, final int end) {
        reentrantLock.lock();
        try {
            final Condition condition = reentrantLock.newCondition();
            while (begin != flag) {
                try {
                    condition.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            print();
            flag = end;
            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    private ReentrantLock reentrantLock;

    private void startV2() {
        reentrantLock = new ReentrantLock();
        flag = 1;
        new MyThreadV2("myV2-a", 1, 2).start();
        new MyThreadV2("myV2-b", 2, 3).start();
        new MyThreadV2("myV2-c", 3, 4).start();
    }



}

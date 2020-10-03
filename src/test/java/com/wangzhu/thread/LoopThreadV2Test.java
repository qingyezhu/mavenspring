package com.wangzhu.thread;

/**
 * Created by wang.zhu on 2020-08-19 18:11.
 **/
public class LoopThreadV2Test {
    public static void main(String[] args) {
        final MyLoop myLoop = new MyLoop(0);
        prepare(myLoop);
        start(myLoop);
    }

    private static void prepare(final MyLoop myLoop){
        new Thread() {
            @Override
            public void run() {
                myLoop.call(1, 2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                myLoop.call(2, 3);
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                myLoop.call(3, 4);
            }
        }.start();

    }

    private static void start(final MyLoop myLoop){
        synchronized (myLoop){
            myLoop.flag = 1;
            myLoop.notifyAll();
        }
    }

    static class MyLoop {
        private int index = 0;
        private volatile int flag;

        public MyLoop(int flag) {
            this.flag = flag;
        }

        private void call(final int current, final int next) {
            synchronized (this) {
                while (flag != current) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                flag = next;
                print();
                notifyAll();
            }
        }

        private void print() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() + ": " + (index++));
            }
        }
    }
}

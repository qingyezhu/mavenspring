package com.wangzhu.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhu on 2021-05-02 11:21.
 **/
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor() {
        super(5, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        final MyRun myRun = (MyRun) r;
//        System.out.println(Thread.currentThread().getName() + "-" + myRun.getTraceId() + "---beforeExecute");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        final MyRun myRun = (MyRun) r;
//        System.out.println(Thread.currentThread().getName() + "-" + myRun.getTraceId() + "---afterExecute");
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        super.terminated();
        System.out.println("over");
    }

    static abstract class MyRun implements Runnable {

        private String traceId;

        public MyRun(String traceId) {
            this.traceId = traceId;
        }

        public String getTraceId() {
            return traceId;
        }
    }
}

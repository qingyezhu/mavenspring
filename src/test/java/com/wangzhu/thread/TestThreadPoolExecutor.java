package com.wangzhu.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhu on 2021-05-02 11:26.
 **/
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor();
//        myThreadPoolExecutor.prestartAllCoreThreads();

//        final MyThreadPoolExecutor.MyRun myRun = new MyThreadPoolExecutor.MyRun("正常") {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100L);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(getTraceId() + "----运行啦");
//            }
//        };
//        myThreadPoolExecutor.execute(myRun);
//
//        final MyThreadPoolExecutor.MyRun myRun1 = new MyThreadPoolExecutor.MyRun("空指针") {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100L);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(getTraceId() + "----不正常");
//                throw new NullPointerException("空指针");
//            }
//        };
//        myThreadPoolExecutor.execute(myRun1);
//
//        final MyThreadPoolExecutor.MyRun myRun2 = new MyThreadPoolExecutor.MyRun("非常不正常") {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100L);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(getTraceId() + "----非常不正常");
//                throw new Error("出错了");
//            }
//        };
//        myThreadPoolExecutor.execute(myRun2);

        for (int i = 0; i < 5; i++) {
            final int j = i;
            final MyThreadPoolExecutor.MyRun tmpMyRun = new MyThreadPoolExecutor.MyRun("正常-" + (i + 1)) {
                @Override
                public void run() {
                    try {
//                        Thread.sleep(100L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (j == 1) {
                        throw new NullPointerException("空指针--" + getTraceId());
                    } else {
                        System.out.println(Thread.currentThread().getName() + "-" + getTraceId() + "----运行啦");
                    }
                }
            };
            myThreadPoolExecutor.execute(tmpMyRun);
        }

        try {
            Thread.sleep(3000);

            myThreadPoolExecutor.shutdown();
            myThreadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

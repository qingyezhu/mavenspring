package com.wangzhu.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wang.zhu on 2021-04-26 00:14.
 **/
public class PrintABC {

    static final char[] CHS = {'A', 'B', 'C'};
    static final int TIMES = 10;

    static class SemaphoreABC extends Thread {
        final int index;
        final Semaphore currentSemaphore;
        final Semaphore nextSemaphore;

        public SemaphoreABC(int index, Semaphore currentSemaphore, Semaphore nextSemaphore) {
            this.index = index;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run() {
            for (int i = 0; i < TIMES; i++) {
                try {
                    currentSemaphore.acquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(CHS[index]);
                if (index == 2) {
                    System.out.println("-----");
                }
                nextSemaphore.release();
            }
        }
    }

    private static void semaphorePrint() {
        final Semaphore[] semaphores = {new Semaphore(1), new Semaphore(0), new Semaphore(0)};
        for (int i = 0, length = CHS.length; i < length; i++) {
            new SemaphoreABC(i, semaphores[i], semaphores[(i + 1) % semaphores.length]).start();
        }
    }

    static class CountDownLatchABC extends Thread {
        final int index;
        final CountDownLatch currentCountDownLatch;
        final CountDownLatch nextCountDownLatch;

        public CountDownLatchABC(int index, CountDownLatch currentCountDownLatch, CountDownLatch nextCountDownLatch) {
            this.index = index;
            this.currentCountDownLatch = currentCountDownLatch;
            this.nextCountDownLatch = nextCountDownLatch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    currentCountDownLatch.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(CHS[index]);
                if (index == 2) {
                    System.out.println("---");
                }
                nextCountDownLatch.countDown();
            }
        }
    }

    private static void countDownLatchPrint() {
        final CountDownLatch[] countDownLatches = {new CountDownLatch(0), new CountDownLatch(1), new CountDownLatch(1)};
        for (int i = 0, length = CHS.length; i < length; i++) {
            new CountDownLatchABC(i, countDownLatches[i], countDownLatches[(i + 1) % countDownLatches.length]).start();
        }
    }


    static class ShareVariable {
        int status;

        public ShareVariable(int status) {
            this.status = status;
        }

        int getStatus() {
            return this.status;
        }

        void addStatus() {
            this.status = (this.status + 1) % CHS.length;
        }
    }

    static class ReentrantLockABC extends Thread {
        final int index;
        final ReentrantLock lock;
        final Condition condition;

        final ShareVariable shareVariable;

        public ReentrantLockABC(int index, ReentrantLock lock, Condition condition, final ShareVariable shareVariable) {
            this.index = index;
            this.lock = lock;
            this.condition = condition;
            this.shareVariable = shareVariable;
        }

        @Override
        public void run() {
            for (int i = 0; i < TIMES; i++) {
                this.lock.lock();
                try {
                    while (index != shareVariable.getStatus()) {
                        try {
                            this.condition.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(CHS[index]);
                    if (index == 2) {
                        System.out.println("----");
                    }
                    this.shareVariable.addStatus();
                    this.condition.signalAll();
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }

    private static void reentrantLockPrint() {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        final ShareVariable shareVariable = new ShareVariable(0);
        for (int i = 0, length = CHS.length; i < length; i++) {
            new ReentrantLockABC(i, lock, condition, shareVariable).start();
        }
    }

    public static void main(String[] args) {
//        semaphorePrint();

//        countDownLatchPrint();

//        reentrantLockPrint();
    }
}

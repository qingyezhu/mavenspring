package com.wangzhu.utils;

/**
 * Created by wang.zhu on 2021-04-22 14:47.
 **/
public class MyLeapArray {

    private final int sampleCount;
    private final int intervalInMs;
    private final int windowLengthInMs;

    public MyLeapArray(final int sampleCount, final int intervalInMs) {
        this.sampleCount = sampleCount;
        this.intervalInMs = intervalInMs;
        this.windowLengthInMs = intervalInMs / sampleCount;
    }

    private int calculateTimeIdx(final long timeMillis) {
        long timeId = timeMillis / this.windowLengthInMs;
        System.out.printf("timeId=%d,", timeId);
        return (int) (timeId % this.sampleCount);
    }

    private long calculateWindowStart(final long timeMillis) {
        return timeMillis - timeMillis % windowLengthInMs;
    }

    private void print() {
        final long timeMillis = System.currentTimeMillis();
        final int idx = calculateTimeIdx(timeMillis);
        final long windowStart = calculateWindowStart(timeMillis);
        System.out.printf("timeMillis=%d, idx=%d, windowStart=%d%n", timeMillis, idx, windowStart);
    }

    public static void main(String[] args) throws InterruptedException {
        final MyLeapArray myLeapArray = new MyLeapArray(2, 1000);
        myLeapArray.print();
        Thread.sleep(100);
        myLeapArray.print();
        Thread.sleep(200);
        myLeapArray.print();
        Thread.sleep(200);
        myLeapArray.print();
        Thread.sleep(500);
        myLeapArray.print();
        Thread.sleep(500);
        myLeapArray.print();
        Thread.sleep(500);
        myLeapArray.print();

        char c = 1;
        short a = '\u0080';

        System.out.println(a);
    }
}

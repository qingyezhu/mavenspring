package com.wangzhu.thread;

/**
 * Created by wang.zhu on 2020-09-23 11:04.
 **/
public class PSGCDemo {
    public static void main(String[] args)throws Exception {
        byte[] bytes1 = new byte[1024 * 1024 * 2];
        byte[] bytes2 = new byte[1024 * 1024 * 2];
        byte[] bytes3 = new byte[1024 * 1024 * 2];
        System.out.println("step 1");
        Thread.sleep(3000);
        byte[] bytes4 = new byte[1024 * 1024 * 2];
        System.out.println("step 2");
        Thread.sleep(3000);
        System.out.println("step 3");
    }
}

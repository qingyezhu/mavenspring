package com.wangzhu.jvm;

/**
 * Created by wang.zhu on 2021-03-31 23:25.
 **/
public class CmsTest {
    private static final int _1MB = 1024 * 1024;


    //-Xmx20m -Xms20m -Xmn10m
    // -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=60
    //-XX:CMSMaxAbortablePrecleanTime=1000 -XX:CMSScheduleRemarkEdenPenetration=10
    //-XX:+CMSScavengeBeforeRemark
    // -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:./gclogs
    public static void main(String[] args) throws Exception {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[7 * _1MB];
        System.in.read();
    }
}

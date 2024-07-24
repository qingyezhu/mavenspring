package com.wangzhu.other;

/**
 * Created by wangz on 2021/6/3 23:27.
 **/
public class GCTenuringThresholdTest {

    //-Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=3 -XX:MaxTenuringThreshold=4 -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -Dfile.encoding=UTF-8
    public static void main(String[] args) throws InterruptedException {


        GCMemoryObject object1 = new GCMemoryObject(2);
        GCMemoryObject object2 = new GCMemoryObject(8);
        GCMemoryObject object3 = new GCMemoryObject(8);
        GCMemoryObject object4 = new GCMemoryObject(8);
        object2 = null;
        object3 = null;
        GCMemoryObject object5 = new GCMemoryObject(8);

        Thread.sleep(4000L);

        object2 = new GCMemoryObject(8);
        object3 = new GCMemoryObject(8);

        object2 = null;
        object3 = null;
        object5 = null;
        GCMemoryObject object6 = new GCMemoryObject(8);
        Thread.sleep(5000L);

        GCMemoryObject object7 = new GCMemoryObject(8);
        GCMemoryObject object8 = new GCMemoryObject(8);
        GCMemoryObject object9 = new GCMemoryObject(8);
        GCMemoryObject object10 = new GCMemoryObject(8);
        Thread.sleep(6000L);
        System.out.println("over");
    }
}
class GCMemoryObject {
    private byte[] bytes = null;

    public GCMemoryObject(int multi) {
        this.bytes = new byte[1024 * 256 * multi];
    }
}

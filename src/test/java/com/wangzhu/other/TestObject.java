package com.wangzhu.other;

import com.mongodb.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wang.zhu on 2021-03-08 16:44.
 **/
public class TestObject {

    @Test
    public void test() {
        Integer[] ints = {1, 2, 3};
        Object[] objects = new Object[4];

        System.arraycopy(ints, 0, objects, 0, ints.length);
        System.out.println(objects);
    }

    @Test
    public void test2(){
        byte[] ints = {1, 2, 3};
        int[] objects = new int[4];

        System.arraycopy(ints, 0, objects, 0, ints.length);
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void test1() {
        final List<DBObject> ops = new ArrayList<>();

        ops.add(new BasicDBObject().append("$match", new BasicDBObject("cid", "123")));

        DBObject all = new BasicDBObject("_id", "123")
                .append("allUsed", new BasicDBObject("$sum", 1));

        DBObject count = new BasicDBObject("$group", all);
        ops.add(count);

        Mongo mongo = new Mongo();
        final DBCollection collection = mongo.getDB("").getCollection("");
        Cursor cursor = collection.aggregate(ops, AggregationOptions.builder().build());
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            System.out.println(doc);
        }
    }


    @Test
    public void test3(){
        int a = 1;
        int b = a++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int c = ++a;
        System.out.println("a = " + a);
        System.out.println("c = " + c);

        a = a++;
        System.out.println("a = " + a);
        a = ++a;
        System.out.println("a = " + a);
    }
}

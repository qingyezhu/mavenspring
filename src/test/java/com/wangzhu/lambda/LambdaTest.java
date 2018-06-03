package com.wangzhu.lambda;

import com.google.common.collect.Maps;
import com.wangzhu.TestBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by wangzhu on 2018/5/14 上午9:43.
 */
public class LambdaTest extends TestBase {

    @Test
    public void testThread() {
        new Thread(() -> {
            System.out.println("hello" + System.currentTimeMillis());
        }).start();
    }

    @Test
    public void testRunnable() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            System.out.println("world " + System.currentTimeMillis());
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testList() {
        List<String> list = Arrays.asList("hello", "world", "cat", "dog");
        list.forEach(s -> {
            System.out.println("item---" + s);
        });

        list.forEach(System.out::println);
    }

    @Test
    public void testMap() {
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");
        map.put(7, "g");
        map.put(8, "h");
        map.put(9, "i");

        map.forEach((s, s2) -> {
            System.out.println(s + "---" + s2);
        });

        List<String> ret = map.entrySet().stream().filter(integerStringEntry -> (integerStringEntry.getKey() % 2 == 0)).map(integerStringEntry -> integerStringEntry.getValue()).collect(Collectors.toList());
        System.out.println(ret);
    }

    @Test
    public void testSort() {
        List<Integer> list = Arrays.asList(100, 34, 1, 1009, 1234, 47, 28, 42);


        Collections.sort(list, (o1, o2) -> {return -1;});
        System.out.println(list);

        Map<Integer, String> map = Maps.newHashMap();

        list.forEach(integer -> {
            if(integer % 2 != 0){
                map.put(integer, "a" + integer);
            }
        });


//        List<String> stringList = list.stream().map(integer -> map.get(integer)).filter(s -> StringUtils.isNotBlank(s)).collect(Collectors.toList());
        List<String> stringList = list.stream().map(integer -> map.get(integer)).collect(Collectors.toList());
        System.out.println(stringList);

        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(value -> value).summaryStatistics();
        System.out.println(intSummaryStatistics);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        System.out.println(list);

        String str = list.stream().map(integer -> integer + "").collect(Collectors.joining(","));
        System.out.println(str);

        List<Integer> filterList = list.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList());
        System.out.println(filterList);

        String[] arr = {"1", "1a", "2b"};
        print("3", arr);


        System.out.println(list.stream().filter(integer -> integer % 2 != 0).limit(2).collect(Collectors.toList()));

    }

    private void print(String cid, String... arr){
        System.out.println(cid);
        System.out.println(Arrays.toString(arr));
        for(String str : arr){
            System.out.println(str);
        }
    }
}

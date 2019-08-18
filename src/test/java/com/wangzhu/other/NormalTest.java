package com.wangzhu.other;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.wangzhu.TestBase;
import com.wangzhu.share.ShareTest;
import com.wangzhu.utils.JSONUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by wangzhu on 2018/6/3 下午10:28.
 */
public class NormalTest extends TestBase {
    @Test
    public void test() {
        String str = "2033048=3.6015825599999998, 2031300=4.66452, 2032232=4.5827279999999995, 2032155=4.329648000000001, 2031860=3.72666384, 2031585=4.604220000000001, 2031384=3.56092128, 2032518=5.19488, 2032317=4.464612000000001, 2032999=4.50778, 2033605=4.48366, 2031988=3.45238128, 2033008=4.56808, 2031986=4.569444, 2033567=3.46444128, 2032754=4.48366, 2032435=4.94174, 101041=4.622432, 2031629=5.03818, 2033654=0.0, 2031311=3.50062128, 2032485=4.400604, 2031399=5.616820000000001, 2032640=4.592160000000001, 2032046=4.72478, 2032086=4.616280000000001, 2033098=4.6886, 2032803=4.73692, 2031913=3.53232, 2031514=4.53883536, 2031437=4.628340000000001, 2031517=4.48366, 2032648=3.8682864, 2031598=3.56540256, 2031950=4.247416800000001, 2031518=3.8155651200000005, 2032575=4.3319, 2032851=3.60606384, 2031685=3.76732512, 2033586=4.71276, 2032057=3.8322000000000003, 2031844=4.00233024, 2033505=4.22838, 2031966=3.49614, 2031489=5.216648, 2031644=3.9392625599999995, 101064=4.628340000000001, 2031848=4.8574, 2031091=3.42378, 2031093=3.6739425599999995, 2031574=4.71272, 2032387=3.51268128, 2031616=3.9028392000000007, 101059=3.53680128, 2032703=4.50778, 2032426=4.667016, 2031378=4.471884, 2032349=4.18014, 2033479=5.2672, 2032424=3.6543038400000003, 2031534=4.67442";

        final Map<String, String> join = Splitter.on(", ").withKeyValueSeparator("=").split(str);
        System.out.println(join);
        join.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey() + "==" + stringStringEntry.getValue());
        });
        System.out.println(join.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()));
        int max = 4;
        for (Map.Entry<String, String> entry : join.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (max-- == 0) {
                break;
            }
        }
    }

    static final long aa = System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1);

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        System.out.println(start + "-1:" + NormalTest.aa);

        System.out.println("2:" + NormalTest.aa);

        try {
            Thread.sleep(1000 * 70L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end + "-3:" + NormalTest.aa);
    }

    @Test
    public void test2() {
        String str = "2033048=3.6015825599999998, 2031300=4.66452, 2032232=4.5827279999999995, 2032155=4.329648000000001, 2031860=3.72666384, 2031585=4.604220000000001, 2031384=3.56092128, 2032518=5.19488, 2032317=4.464612000000001, 2032999=4.50778, 2033605=4.48366, 2031988=3.45238128, 2033008=4.56808, 2031986=4.569444, 2033567=3.46444128, 2032754=4.48366, 2032435=4.94174, 101041=4.622432, 2031629=5.03818, 2033654=0.0, 2031311=3.50062128, 2032485=4.400604, 2031399=5.616820000000001, 2032640=4.592160000000001, 2032046=4.72478, 2032086=4.616280000000001, 2033098=4.6886, 2032803=4.73692, 2031913=3.53232, 2031514=4.53883536, 2031437=4.628340000000001, 2031517=4.48366, 2032648=3.8682864, 2031598=3.56540256, 2031950=4.247416800000001, 2031518=3.8155651200000005, 2032575=4.3319, 2032851=3.60606384, 2031685=3.76732512, 2033586=4.71276, 2032057=3.8322000000000003, 2031844=4.00233024, 2033505=4.22838, 2031966=3.49614, 2031489=5.216648, 2031644=3.9392625599999995, 101064=4.628340000000001, 2031848=4.8574, 2031091=3.42378, 2031093=3.6739425599999995, 2031574=4.71272, 2032387=3.51268128, 2031616=3.9028392000000007, 101059=3.53680128, 2032703=4.50778, 2032426=4.667016, 2031378=4.471884, 2032349=4.18014, 2033479=5.2672, 2032424=3.6543038400000003, 2031534=4.67442";
        final Map<String, String> map = Splitter.on(", ").withKeyValueSeparator("=").split(str);
        List<RoomScore> roomScores = Lists.newArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            RoomScore roomScore = new RoomScore();
            roomScore.setCid(entry.getKey());
            roomScore.setScore(Double.parseDouble(entry.getValue()));
            roomScores.add(roomScore);
        }
        printRoomScore(roomScores);
        Collections.sort(roomScores);
        printRoomScore(roomScores);
    }

    private void printRoomScore(List<RoomScore> roomScores){
        System.out.println("start");
        for(RoomScore roomScore : roomScores){
            System.out.println(roomScore);
        }
        System.out.println("end");
    }

    @Test
    public void test3(){
        Double d = Double.parseDouble(Integer.MAX_VALUE+ "");
        System.out.println(d.longValue());
        System.out.println(Double.parseDouble(Integer.MAX_VALUE + ""));
    }

    @Test
    public void test4(){
        System.out.println(10+10+"a");
        System.out.println("a"+10+10);
    }
}

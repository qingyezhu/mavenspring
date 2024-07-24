package com.wangzhu.other;


import com.wangzhu.spring.App;

import java.util.*;

/**
 * Created by wangz on 2024/7/13 15:37.
 **/
public class TestScore {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String levelStr = cin.nextLine();
        String infoStr = cin.nextLine();


        handle(levelStr, infoStr);
        //handle("40000,20000,10000,5000", "101,52000#102,21000#103,15000#104,30000#105,4000#106,7000#107,43000#108,2500");
    }

    static void handle(String levelStr, String infoStr) {
        List<Integer> levels = new ArrayList<>();
        for (String str : levelStr.split(",")) {
            levels.add(Integer.parseInt(str));
        }

        List<Integer> scores = new ArrayList<>();
        for (String str : infoStr.split("#")) {
            scores.add(Integer.parseInt(str.split(",")[1]));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int score : scores) {
            int index = getLevelIndex(score, levels);

            List<Integer> list = map.get(index);
            if (list == null) {
                list = new ArrayList<>();
                map.put(index, list);
            }
            list.add(score);
        }

        StringBuilder accum = new StringBuilder();
        for (int i = 0, size = levels.size(); i < size; i++) {
            if (i > 0) {
                accum.append(",");
            }
            accum.append(getMiddle(map.get(i)));
        }
        accum.append(",");
        accum.append(getMiddle(map.get(-1)));

        System.out.println(accum);
    }

    static int getMiddle(List<Integer> list) {
        if (list == null) {
            return -1;
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        if (list.size() % 2 != 0) {
            // 计数，中间那个数
            return list.get(list.size() / 2);
        }
        //  偶数，中间两个数的平均数
        return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;

    }

    static int getLevelIndex(int score, List<Integer> levels) {
        for (int i = 0, size = levels.size(); i < size; i++) {
            if (score >= levels.get(i)) {
                return i;
            }
        }
        return -1;
    }
}

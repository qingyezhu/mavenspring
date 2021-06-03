package com.wangzhu.utils;

/**
 * Created by wang.zhu on 2021-05-31 19:30.
 **/
public class Main {

    public static void main(String[] args) {
        String str = encode(39.923201, 5);
        System.out.println(str);
    }

    static String encode(double lat, int size) {
        //注意相等
        //相等是右边
        int times = size * 4;
        StringBuilder accum = new StringBuilder();
        double left = -90d, right = 90d;
        while (left <= right && times > 0) {
            double mid = (left + right) / 2d;
            if (lat >= mid) {
                //大于等于是右边
                left = mid;
                accum.append("1");
            } else {
                right = mid;
                accum.append("0");
            }
            times--;
        }
        final String temp = accum.toString();
        System.out.println(temp);
        char[] chs = temp.toCharArray();
        StringBuilder retAccum = new StringBuilder();
        for (int i = 0, len = chs.length; i < len; i += 4) {
            int num = toInt(chs, i, i + 4);
            if (num < 10) {
                retAccum.append(num);
            } else {
                char ch = (char) ('a' + (num - 10));
                retAccum.append(ch);
            }
        }
        return retAccum.toString();
    }

    static int toInt(char[] chs, int start, int end) {
        int ret = 0, index = 0;
        for (int i = end - 1; i >= start; i--) {
            if (chs[i] == '1') {
                //倒了。。。
                ret += 1 << index;
            }
            index++;
        }
        return ret;
    }


}

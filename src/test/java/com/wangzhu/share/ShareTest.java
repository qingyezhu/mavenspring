package com.wangzhu.share;

import com.wangzhu.TestBase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhu on 2018/5/30 下午4:42.
 */
public class ShareTest extends TestBase {
    @Test
    public void test() {
        try {
            new AbstractShareQuery(10, Arrays.asList("101", "100", "302", "201"), null, null) {
                @Override
                public void callback(String hashKey, List<String> list) {
                    System.out.println(hashKey + "-" + list);
                }
            }.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

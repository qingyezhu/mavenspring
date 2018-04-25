package com.wangzhu;

import com.wangzhu.log4j.Log4jFlushLogUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;

/**
 * Created by wangzhu on 2018/4/25 下午11:47.
 */
public class TestBase {
    @Before
    public void before(){
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                StopWatch clock = new StopWatch();
                clock.start();
                System.out.println("jvm开始关闭 log4j开始清除缓存日志...");
                try {
                    Log4jFlushLogUtil.flushAllLog();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    clock.stop();
                    System.out.println("log4j清除缓存日志结束 耗时:" + clock.getTime());
                }
            }
        });
    }
}

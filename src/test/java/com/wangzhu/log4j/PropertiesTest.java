package com.wangzhu.log4j;

import com.wangzhu.TestBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhu on 2018/4/15 下午5:27.
 */
public class PropertiesTest extends TestBase {
    static {
        System.setProperty("log4j.defaultInitOverride", "true");
        PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
    }

    private static final Logger logger = LoggerFactory.getLogger(PropertiesTest.class);

    private static final Logger fileLog1 = LoggerFactory.getLogger("f1");
    private static final Logger fileLog2 = LoggerFactory.getLogger("f2");
    private static final Logger fileLog3 = LoggerFactory.getLogger("f3");

    @Test
    public void test() {
        for (int i = 0; i < 10000; i++) {
            logger.info("{}:time:{}", i, System.currentTimeMillis());
            fileLog1.info("{}:hello", i);
            fileLog2.info("{}:world", i);
            fileLog3.info("{}:welcome", i);
        }
    }
}
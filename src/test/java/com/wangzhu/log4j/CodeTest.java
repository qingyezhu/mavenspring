package com.wangzhu.log4j;

import org.apache.log4j.*;
import org.junit.Test;

/**
 * Created by wangzhu on 2018/4/15 下午5:22.
 */
public class CodeTest {
    static {
        try {
            System.setProperty("log4j.defaultInitOverride", "true");
            Logger rootLogger = Logger.getRootLogger();
            rootLogger.setLevel(Level.DEBUG);
            rootLogger.removeAllAppenders();
            rootLogger.addAppender(new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss,SSS} [%t] %-5p %l - %m%n")));

            RollingFileAppender rollingFileAppender1 = new RollingFileAppender();
            rollingFileAppender1.setLayout(new PatternLayout("%m%n"));
            rollingFileAppender1.setFile("log4jTest/log_1.txt");
            rollingFileAppender1.setAppend(true);
            rollingFileAppender1.setBufferedIO(true);
            //单独设置时，需要activateOptions
            rollingFileAppender1.activateOptions();

            Logger log1 = Logger.getLogger("log1");
            log1.removeAllAppenders();
            log1.addAppender(rollingFileAppender1);
            log1.setAdditivity(false);
            log1.setLevel(Level.INFO);


            RollingFileAppender rollingFileAppender2 = new RollingFileAppender(new PatternLayout("%m%n"), "log4jTest/log_2.txt", true);

            Logger log2 = Logger.getLogger("log2");
            log2.removeAllAppenders();
            log2.addAppender(rollingFileAppender2);
            log2.setAdditivity(false);
            log2.setLevel(Level.INFO);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    //当有BufferedIO=true时，需要给JVM一个钩子，当JVM停止时，刷新缓存
                    LogManager.shutdown();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final org.slf4j.Logger logger1 = org.slf4j.LoggerFactory.getLogger("log1");
    private static final org.slf4j.Logger logger2 = org.slf4j.LoggerFactory.getLogger("log2");

    @Test
    public void test(){
        for(int i = 0;i < 10000;i ++) {
            logger1.info("{}", i);
        }
        for(int i = 0;i < 10000;i ++) {
            logger2.info("{}", i);
        }
    }
}

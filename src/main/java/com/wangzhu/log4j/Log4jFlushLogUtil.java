package com.wangzhu.log4j;

import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.helpers.QuietWriter;

import java.lang.reflect.Field;
import java.util.Enumeration;

/**
 * Created by wangzhu on 2018/4/25 下午11:43.
 */
public class Log4jFlushLogUtil {
    public static void flushAllLog() throws Exception {
        flushAppendLog(LogManager.getRootLogger().getAllAppenders());
        Enumeration currentLoggers = LogManager.getLoggerRepository().getCurrentLoggers();
        while (currentLoggers.hasMoreElements()) {
            Object currentLogger = currentLoggers.nextElement();
            if (currentLogger instanceof Logger) {
                Logger logger = (Logger) currentLogger;
                flushAppendLog(logger.getAllAppenders());
            }
        }
    }

    private static void flushAppendLog(Enumeration allAppenders) throws Exception {
        while (allAppenders.hasMoreElements()) {
            Object appender = allAppenders.nextElement();
            System.out.println("appender: " + appender);
            if (appender instanceof FileAppender) {
                FileAppender fileAppender = (FileAppender) appender;
                System.out.println("name=" + fileAppender.getName());
                boolean immediateFlush = fileAppender.getImmediateFlush();
                if (!immediateFlush) {
                    Class<?> writerAppenderClass = fileAppender.getClass();
                    while(!writerAppenderClass.equals(WriterAppender.class)){
                        writerAppenderClass = writerAppenderClass.getSuperclass();
                    }
                    Field qwField = writerAppenderClass.getDeclaredField("qw");
                    qwField.setAccessible(true);

                    QuietWriter quietWriter = (QuietWriter) qwField.get(appender);
                    quietWriter.flush();
                    fileAppender.setImmediateFlush(true);
                    fileAppender.setBufferedIO(false);
                    fileAppender.activateOptions();
                }
            }
        }
    }
}

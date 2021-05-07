package com.wangzhu.other;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhu on 2021-04-07 14:01.
 **/
public class ScheduleTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTest.class);


    private void print(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor){
        logger.info("active|{}|queue|{}", scheduledThreadPoolExecutor.getActiveCount(), scheduledThreadPoolExecutor.getQueue().size());
        final BlockingQueue<Runnable> blockingQueue = scheduledThreadPoolExecutor.getQueue();
        Iterator<Runnable> iterator = blockingQueue.iterator();
        while(iterator.hasNext()){
            System.out.println("++");
            Runnable runnable = iterator.next();
            runnable.run();
            System.out.println("+++");
        }
        System.out.println("---------------");
    }

    @Test
    public void testCancel() {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3, new ThreadFactoryBuilder().setNameFormat("my-schedule-%d").setDaemon(Boolean.TRUE).build());
        print(scheduledThreadPoolExecutor);
        final Future future1 = scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            logger.info("start1");
            try{
                Thread.sleep(200L);
            }catch (Exception e){
                logger.error("interrupt1", e);
            }
            logger.info("end1");
        },1, 800, TimeUnit.MILLISECONDS);
        print(scheduledThreadPoolExecutor);
        final Future future2 = scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            logger.info("start2");
            try{
                Thread.sleep(500L);
            }catch (Exception e){
                logger.error("interrupt2", e);
            }
            logger.info("end2");
        },1, 1500, TimeUnit.MILLISECONDS);
        print(scheduledThreadPoolExecutor);
        try{
            Thread.sleep(10 * 1000L);
        }catch (Exception e){
            logger.error("interrupt main 10", e);
        }
        print(scheduledThreadPoolExecutor);
        future2.cancel(Boolean.TRUE);

        try{
            Thread.sleep(5 * 1000L);
        }catch (Exception e){
            logger.error("interrupt main 5", e);
        }
        future1.cancel(Boolean.TRUE);
        print(scheduledThreadPoolExecutor);
        try{
            Thread.sleep(2 * 1000L);
        }catch (Exception e){
            logger.error("interrupt main 2", e);
        }
        print(scheduledThreadPoolExecutor);
    }
}

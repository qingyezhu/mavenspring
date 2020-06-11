package com.wangzhu.spring.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wang.zhu on 2020-04-14 21:36.
 **/
@Service
@EnableScheduling
public class ScheduledService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledService.class);

    public ScheduledService() {
        logger.info("init");

//        Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(()->{
//            //delay+sleep
//            testFixedDelay();
//        },0, 5, TimeUnit.SECONDS);

//        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(()->{
//            //rate>sleep则是rate，否则是sleep
//            testFixedRate();
//        },0, 5, TimeUnit.SECONDS);
    }

    //delay+sleep 执行完5秒后再执行
    @Scheduled(fixedDelay = 5000)
    public void testFixedDelay() {
        logger.info("delay start");
        try {
//            Thread.sleep(8000L);
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("delay end");
    }

    //rate>sleep则是rate，否则是sleep 当执行时间到了，上一个执行还没有执行完，等上一个执行完，立即执行
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        logger.info("rate start");
        try {
//            Thread.sleep(8000L);
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("rate end");
    }

    //每5秒执行一次，若是还在sleep则跳过
//    @Scheduled(cron = "0/5 * * * * ?")
    public void testCron() {
        logger.info("start cron");
        try {
            Thread.sleep(8000L);
//            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("end cron");
    }

    @Scheduled(cron = "1,3 0 0 * * ?")
    public void testCron1(){
        System.out.println("testCron1");
    }
}

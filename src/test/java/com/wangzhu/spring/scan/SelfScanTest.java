package com.wangzhu.spring.scan;

import com.wangzhu.service.SelfService;
import com.wangzhu.spring.scanv2.SelfComponentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wang.zhu on 2020-06-13 21:57.
 **/
public class SelfScanTest {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SelfComponentConfig.class);
        final String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }


        SelfService selfService = applicationContext.getBean(SelfService.class);
        selfService.print();

        try{
            Thread.sleep(10L);
        }catch (Exception e){
            e.printStackTrace();
        }
        selfService = (SelfService)applicationContext.getBean("selfScanService");
        selfService.print();


    }
}

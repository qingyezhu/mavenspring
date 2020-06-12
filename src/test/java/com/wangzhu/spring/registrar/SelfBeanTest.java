package com.wangzhu.spring.registrar;

import com.wangzhu.service.SelfBeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wang.zhu on 2020-06-12 14:20.
 **/
public class SelfBeanTest {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SelfBeanConfig.class);

        final String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println();


        final SelfBeanService selfBeanService = (SelfBeanService)applicationContext.getBean("selfBeanService");
        selfBeanService.print();
    }
}

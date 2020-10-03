package com.wangzhu.spring.registrar;

import com.wangzhu.service.IAllUserService;
import com.wangzhu.service.SelfBService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wang.zhu on 2020-06-12 16:24.
 **/
public class SelfServiceTest {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SelfServiceConfig.class);

        final String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

//        final SelfBService selfBService = applicationContext.getBean(SelfBService.class);
//        selfBService.print();

        final IAllUserService allUserService = applicationContext.getBean(IAllUserService.class);
        allUserService.print();
    }
}

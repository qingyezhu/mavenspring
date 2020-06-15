package com.wangzhu.spring.scan;

import com.wangzhu.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by wang.zhu on 2020-06-15 18:54.
 **/
@Configuration
@PropertySource(value = {"classpath:config.properties"}, ignoreResourceNotFound = true)
@ImportResource("classpath*:spring-import.xml")
public class MyConfigTest {


    @Bean
    public PropertySourcesPlaceholderConfigurer cre(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfigTest.class);
        MyService myService = applicationContext.getBean(MyService.class);
        myService.print();
    }
}

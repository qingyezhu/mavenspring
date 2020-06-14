package com.wangzhu.scan;

import com.wangzhu.spring.scan.SelfScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wang.zhu on 2020-06-13 18:18.
 **/
public class SelfScanTest {

    public static void main(String[] args) {
        final ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SelfScanConfig.class);
    }
}

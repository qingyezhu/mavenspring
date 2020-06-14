package com.wangzhu.spring.scan;

import java.lang.annotation.*;

/**
 * Created by wang.zhu on 2020-06-13 17:32.
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SelfBeanScan {
    String beanName();
}

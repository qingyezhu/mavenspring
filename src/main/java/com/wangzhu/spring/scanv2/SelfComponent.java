package com.wangzhu.spring.scanv2;

import java.lang.annotation.*;

/**
 * Created by wang.zhu on 2020-06-13 22:11.
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SelfComponent {
    String value();
}

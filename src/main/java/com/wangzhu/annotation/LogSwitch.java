package com.wangzhu.annotation;

import java.lang.annotation.*;

/**
 * Created by wangzhu on 2019/4/26 下午12:50.
 */
@Target (ElementType.METHOD)
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface LogSwitch {
    boolean enabled();
}

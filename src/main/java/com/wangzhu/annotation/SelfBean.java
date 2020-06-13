package com.wangzhu.annotation;

import com.wangzhu.spring.registrar.SelfBeanRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wang.zhu on 2020-06-12 12:05.
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SelfBeanRegistrar.class)
@Component
public @interface SelfBean {
    String name();
}

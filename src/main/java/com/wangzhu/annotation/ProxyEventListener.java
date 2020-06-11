package com.wangzhu.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by wang.zhu on 2020-06-09 20:34.
 **/
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
public @interface ProxyEventListener {

    @AliasFor(annotation = EventListener.class, attribute = "classes")
    Class<?>[] clzss() default {};

}

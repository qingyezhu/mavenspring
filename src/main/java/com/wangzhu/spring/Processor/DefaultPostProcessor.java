package com.wangzhu.spring.Processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by wangzhu on 2018/4/24 下午11:41.
 */
public class DefaultPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("DefaultPostProcessor postProcessBeforeInitialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("DefaultPostProcessor postProcessAfterInitialization " + beanName);
        return bean;
    }
}

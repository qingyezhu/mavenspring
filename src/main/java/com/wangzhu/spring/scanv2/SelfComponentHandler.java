package com.wangzhu.spring.scanv2;

import com.wangzhu.proxy.MyProxy;
import com.wangzhu.service.IMyInterface;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;
import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by wang.zhu on 2020-06-14 10:52.
 **/
public class SelfComponentHandler extends AbstractComponentHandler {

    public SelfComponentHandler() {
        super(SelfComponent.class);
    }

    @Override
    void doHandler(Map<String, Object> attributes, AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry) {
        logger.info("detail annotatedBeanDefinition|{}|registry|{}", annotatedBeanDefinition, registry);

        final String name = (String)attributes.get("value");

        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyProxy.class);
        beanDefinitionBuilder.addConstructorArgValue(IMyInterface.class);

//        registry.registerBeanDefinition("depeOnMyProxy", beanDefinitionBuilder.getBeanDefinition());


//        final MyProxy myProxy = new MyProxy(IMyInterface.class);

        final String beanName = beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry);
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName, new String[]{name});
        definitionHolder.getBeanDefinition().getPropertyValues().addPropertyValue("instance", beanDefinitionBuilder.getBeanDefinition());

        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }
}

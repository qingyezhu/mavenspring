package com.wangzhu.spring.scanv2;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

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
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, (String) attributes.get("value"));
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }
}

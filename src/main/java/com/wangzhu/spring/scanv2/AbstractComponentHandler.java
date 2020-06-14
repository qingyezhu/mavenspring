package com.wangzhu.spring.scanv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Created by wang.zhu on 2020-06-14 10:42.
 **/
public abstract class AbstractComponentHandler {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final Class<? extends Annotation> annotationType;
    private final TypeFilter typeFilter;

    protected AbstractComponentHandler(Class<? extends Annotation> annotationType) {
        this.annotationType = annotationType;
        this.typeFilter = new AnnotationTypeFilter(annotationType);
    }

    public TypeFilter getTypeFilter() {
        return typeFilter;
    }

    void handler(AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry) {
        final Map<String, Object> attributes = annotatedBeanDefinition.getMetadata().getAnnotationAttributes(annotationType.getName());
        if (attributes != null) {
            doHandler(attributes, annotatedBeanDefinition, registry);
        }
    }

    abstract void doHandler(Map<String, Object> attributes, AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry);
}

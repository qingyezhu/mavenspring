package com.wangzhu.spring.scan;

import com.wangzhu.annotation.SelfBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/**
 * Created by wang.zhu on 2020-06-13 18:15.
 **/
public class SelfScanRegistrar extends AbstractRegistrar {

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableSelfScan.class;
    }

    @Override
    protected List<TypeFilter> getIncludeFilters() {
        return Collections.singletonList(new AnnotationTypeFilter(SelfBean.class));
    }

    @Override
    protected BeanDefinitionHolder builderBeanDefinitionHolder(AnnotatedBeanDefinition annotatedBeanDefinition) {
        return null;
    }
}

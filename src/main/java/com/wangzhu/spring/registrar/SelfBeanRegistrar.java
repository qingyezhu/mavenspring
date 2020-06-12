package com.wangzhu.spring.registrar;

import com.wangzhu.annotation.SelfBean;
import com.wangzhu.service.SelfBeanService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by wang.zhu on 2020-06-12 12:06.
 **/
public class SelfBeanRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        final AnnotationAttributes attributes =
                AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(SelfBean.class.getName()));
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SelfBeanService.class);
        beanDefinitionBuilder.addPropertyValue("desc", "self bean service");
        System.out.println("name:===" + attributes.getString("name"));
        registry.registerBeanDefinition("selfBeanService", beanDefinitionBuilder.getBeanDefinition());
    }
}

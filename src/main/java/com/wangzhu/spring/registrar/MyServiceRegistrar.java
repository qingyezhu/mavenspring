package com.wangzhu.spring.registrar;

import com.wangzhu.service.MyServiceFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by wang.zhu on 2020-06-17 11:40.
 **/
public class MyServiceRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder  = BeanDefinitionBuilder.genericBeanDefinition(MyServiceFactory.class);
        beanDefinitionBuilder.addPropertyValue("interfaceName", "com.wangzhu.service.MyService");
        registry.registerBeanDefinition("myServiceFactory", beanDefinitionBuilder.getBeanDefinition());
    }
}

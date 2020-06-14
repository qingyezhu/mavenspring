package com.wangzhu.spring.registrar;

import com.wangzhu.service.SelfBService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by wang.zhu on 2020-06-12 16:26.
 **/
public class SelfServiceRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder beanDefinitionBuilder  = BeanDefinitionBuilder.genericBeanDefinition(SelfBService.class);
        final BeanDefinition propertyBeanDefinition = registry.getBeanDefinition("selfdservice");
        System.out.println("--------" + propertyBeanDefinition);
//        beanDefinitionBuilder.addPropertyReference("selfDService", "selfdservice");
        beanDefinitionBuilder.addPropertyValue("selfDService", propertyBeanDefinition);
        registry.registerBeanDefinition("selfB", beanDefinitionBuilder.getBeanDefinition());

    }
}

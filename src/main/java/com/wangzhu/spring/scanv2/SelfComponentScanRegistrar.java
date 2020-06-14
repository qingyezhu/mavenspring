package com.wangzhu.spring.scanv2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wang.zhu on 2020-06-13 21:29.
 **/
public class SelfComponentScanRegistrar implements ImportBeanDefinitionRegistrar {
    private static final String BEAN_NAME = "selfComponentScanRegisteringPostProcessor";


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final Set<String> packagesToScan = getPackagesToScan(importingClassMetadata);
        System.out.println("packagesToScan:" + packagesToScan);
        if (registry.containsBeanDefinition(BEAN_NAME)) {
            updatePostProcessor(registry, packagesToScan);
        } else {
            addPostProcessor(registry, packagesToScan);
        }
    }

    private Set<String> getPackagesToScan(final AnnotationMetadata annotationMetadata) {
        final AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(annotationMetadata.getAnnotationAttributes(SelfComponentScan.class.getName()));
        final String[] basePackages = attributes.getStringArray("basePackages");
        final Class<?>[] basePackageClasses = attributes.getClassArray("basePackageClasses");

        final Set<String> packagesToScan = new LinkedHashSet<>(Arrays.asList(basePackages));
        for (final Class<?> basePackageClass : basePackageClasses) {
            packagesToScan.add(ClassUtils.getPackageName(basePackageClass));
        }
        if (packagesToScan.isEmpty()) {
            packagesToScan.add(ClassUtils.getPackageName(annotationMetadata.getClassName()));
        }
        packagesToScan.removeIf((candidate) -> !StringUtils.hasText(candidate));
        return packagesToScan;
    }

    private void addPostProcessor(final BeanDefinitionRegistry registry, final Set<String> packagesToScan) {
        final BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SelfComponentScanRegisteringPostProcessor.class);
        beanDefinitionBuilder.addPropertyValue("packagesToScan", packagesToScan);
        registry.registerBeanDefinition(BEAN_NAME, beanDefinitionBuilder.getBeanDefinition());
    }

    private void updatePostProcessor(final BeanDefinitionRegistry registry, final Set<String> packagesToScan) {
        final BeanDefinition beanDefinition = registry.getBeanDefinition(BEAN_NAME);
        final Set<String> mergedPackages = (Set<String>) beanDefinition.getPropertyValues().get("packagesToScan");
        System.out.println("mergedPackages===" + mergedPackages);
        mergedPackages.addAll(packagesToScan);
    }
}

package com.wangzhu.spring.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wang.zhu on 2020-06-13 15:34.
 **/
public abstract class AbstractRegistrar implements EnvironmentAware, ResourceLoaderAware, ImportBeanDefinitionRegistrar {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    protected ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final Set<String> packagesToScan = getPackagesToScan(importingClassMetadata);
        scan(registry, packagesToScan);
    }

    private Set<String> getPackagesToScan(final AnnotationMetadata annotationMetadata) {
        final AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(annotationMetadata.getAnnotationAttributes(getAnnotation().getName()));
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

    protected abstract Class<? extends Annotation> getAnnotation();

    private void scan(BeanDefinitionRegistry registry, Set<String> packages) {
        final ClassPathScanningCandidateComponentProvider scanner = getScanner();
        for (final String basePackage : packages) {
            final Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(basePackage);
            logger.info("detail basePackage|{}|beanDefinitions|{}", basePackage, beanDefinitions);
            for (final BeanDefinition beanDefinition : beanDefinitions) {
                if (beanDefinition instanceof AnnotatedBeanDefinition) {
                    final AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) beanDefinition;
                    registerBeanDefinition(annotatedBeanDefinition, registry);
                }
            }
        }
    }

    protected final ClassPathScanningCandidateComponentProvider getScanner() {
        final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                return AbstractRegistrar.this.isCandidateComponent(beanDefinition);
            }
        };
        scanner.setEnvironment(this.environment);
        scanner.setResourceLoader(this.resourceLoader);

        final List<TypeFilter> includeFilters = getIncludeFilters();
        includeFilters.forEach(scanner::addIncludeFilter);

        return scanner;
    }

    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return metadata.isIndependent() && metadata.isInterface();
    }

    protected abstract List<TypeFilter> getIncludeFilters();

    private void registerBeanDefinition(final AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry) {
        final BeanDefinitionHolder definitionHolder = builderBeanDefinitionHolder(annotatedBeanDefinition);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }

    protected abstract BeanDefinitionHolder builderBeanDefinitionHolder(AnnotatedBeanDefinition annotatedBeanDefinition);

}

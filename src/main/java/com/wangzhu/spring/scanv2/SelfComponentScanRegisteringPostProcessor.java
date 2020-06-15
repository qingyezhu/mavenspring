package com.wangzhu.spring.scanv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by wang.zhu on 2020-06-13 21:50.
 **/
public class SelfComponentScanRegisteringPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware, InitializingBean {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<AbstractComponentHandler> HANDLERS;

    static {
        final List<AbstractComponentHandler> handlers = new ArrayList<>();
        handlers.add(new SelfComponentHandler());
        HANDLERS = Collections.unmodifiableList(handlers);
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Set<String> packagesToScan;

    public void setPackagesToScan(Set<String> packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("packagesToScan===" + packagesToScan);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        final ClassPathScanningCandidateComponentProvider scanner = getScanner();
        for (final String basePackage : packagesToScan) {
            scanPackage(registry, scanner, basePackage);
        }
    }

    protected final ClassPathScanningCandidateComponentProvider getScanner() {
        final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false) {

        };
        scanner.setEnvironment(applicationContext.getEnvironment());
        scanner.setResourceLoader(applicationContext);

        HANDLERS.forEach(abstractComponentHandler -> scanner.addIncludeFilter(abstractComponentHandler.getTypeFilter()));

        return scanner;
    }

    private void scanPackage(final BeanDefinitionRegistry registry, final ClassPathScanningCandidateComponentProvider scanner, final String basePackage) {
        final Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(basePackage);
        logger.info("detail basePackage|{}|beanDefinitions|{}", basePackage, beanDefinitions);
        for (final BeanDefinition candidate : beanDefinitions) {
            if (candidate instanceof AnnotatedBeanDefinition) {
                HANDLERS.forEach(abstractComponentHandler -> abstractComponentHandler.handler((AnnotatedBeanDefinition) candidate, registry));
            }
        }
    }
}

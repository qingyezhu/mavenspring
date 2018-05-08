package com.wangzhu.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    public void start() {
        System.out.println("BeanLifeCycle start");
    }

    public void stop() {
        System.out.println("BeanLifeCycle stop");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifeCycle afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("BeanLifeCycle destroy");
    }

    public void defaultInit() {
        System.out.println("BeanLifeCycle defaultInit");
    }

    public void defaultDestroy() {
        System.out.println("BeanLifeCycle defaultDestroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanLifeCycle postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanLifeCycle preDestroy");
    }

    //     @PostConstruct --> InitializingBean --> start
    //     @PreDestroy --> DisposableBean --> stop

    //当没有start时，才会使用defaultInit，同理没有stop时，才会使用defaultDestroy
}

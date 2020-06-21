package com.wangzhu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by wang.zhu on 2020-06-17 11:34.
 **/
public class MyServiceFactory implements FactoryBean<Object>, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(MyServiceFactory.class);

    private String interfaceName;
    private Class<?> interfaceClazz;

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            this.interfaceClazz = Class.forName(this.interfaceName);
        }catch (Exception e){
            logger.error("exception interfaceName=" + this.interfaceName, e);
        }
        logger.info("init interfaceName|{}|interfaceClazz|{}", this.interfaceName, this.interfaceClazz);
    }

    @Override
    public Object getObject() throws Exception {
        return this.interfaceClazz.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        logger.info("get type interfaceName|{}|interfaceClazz|{}", this.interfaceName, this.interfaceClazz);
        return this.interfaceClazz;
    }
}

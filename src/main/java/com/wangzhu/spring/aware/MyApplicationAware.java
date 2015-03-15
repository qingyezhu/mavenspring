package com.wangzhu.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationAware implements ApplicationContextAware {

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("MyApplicationAware: "
				+ applicationContext.getBean("myApplicationAware").hashCode());
	}

}

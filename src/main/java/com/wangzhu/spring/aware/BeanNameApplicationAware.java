package com.wangzhu.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanNameApplicationAware implements ApplicationContextAware,
		BeanNameAware {

	private String beanName;

	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("BeanNameApplicationAware: " + beanName);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("BeanNameApplicationAware: "
				+ applicationContext.getBean(beanName).hashCode());
	}

}

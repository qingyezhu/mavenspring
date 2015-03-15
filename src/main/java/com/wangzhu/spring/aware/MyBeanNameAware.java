package com.wangzhu.spring.aware;

import org.springframework.beans.factory.BeanNameAware;

public class MyBeanNameAware implements BeanNameAware {

	public void setBeanName(String beanName) {
		System.out.println("MyBeanName: " + beanName);
	}

}

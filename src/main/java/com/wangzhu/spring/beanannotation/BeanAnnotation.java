package com.wangzhu.spring.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myBeanAnnotation")
@Scope("prototype")
public class BeanAnnotation {

	public void say(String msg) {
		System.out.println("BeanAnnotation: " + msg);
	}

	public void printHashCode() {
		System.out.println("BeanAnnotation: " + this.hashCode());
	}
}

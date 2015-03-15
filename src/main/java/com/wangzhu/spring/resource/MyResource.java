package com.wangzhu.spring.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MyResource implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void resourceByPath(String location) throws IOException {
		Resource resource = applicationContext.getResource(location);
		System.out.println("fileName: " + resource.getFilename());
		System.out.println("contentLength: " + resource.contentLength());
	}

}

package com.wangzhu.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath*:spring-quartz.xml");
	}
}

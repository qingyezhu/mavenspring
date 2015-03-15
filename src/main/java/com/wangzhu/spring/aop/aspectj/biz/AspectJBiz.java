package com.wangzhu.spring.aop.aspectj.biz;

import org.springframework.stereotype.Service;

@Service
public class AspectJBiz {

	public String save(String args) {
		System.out.println("AspectBiz save: " + args);
		return "AspectBiz save return";
	}
}

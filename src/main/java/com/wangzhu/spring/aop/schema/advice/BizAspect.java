package com.wangzhu.spring.aop.schema.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class BizAspect {
	public void before() {
		System.out.println("BizAspect before.");
	}

	public void afterReturning() {
		System.out.println("BizAspect afterReturning.");
	}

	public void afterThrowing() {
		System.out.println("BizAspect afterThrowing.");
	}

	public void after() {
		System.out.println("BizAspect after.");
	}

	public Object around(ProceedingJoinPoint pjp) {
		Object obj = null;
		try {
			System.out.println("BizAspect around-1.");
			obj = pjp.proceed();
			System.out.println("BizAspect around-2.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Object aroundInit(ProceedingJoinPoint pjp, String bizName, int times) {
		System.out.println("BizAspect aroundInit" + bizName + "  " + times);
		Object obj = null;
		try {
			System.out.println("BizAspect aroundInit-1.");
			obj = pjp.proceed();
			System.out.println("BizAspect aroundInit-2.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}

}

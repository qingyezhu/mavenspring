package com.wangzhu.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BizAspectJ {

	@Pointcut("execution(* com.wangzhu.spring.aop.aspectj.biz.*Biz.*(..))")
	public void pointcut() {

	}

	@Pointcut("within(com.wangzhu.spring.aop.aspectj.biz.*)")
	public void bizPointcut() {

	}

	@Before("pointcut()")
	public void before() {
		System.out.println("BizAspect before.");
	}

	@Before("pointcut() && args(param)")
	public void beforeWithParam(Object param) {
		System.out.println("BizAspect beforeWithParam param: " + param);
	}

	@After("pointcut()")
	public void after() {
		System.out.println("BizAspect after.");
	}

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("BizAspect afterReturning.");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "returnVal")
	public void afterReturningParam(Object returnVal) {
		System.out
				.println("BizAspect afterReturningParam return: " + returnVal);
	}

	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		System.out.println("BizAspect afterThrowing.");
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("BizAspect around 1.");
		Object obj = pjp.proceed();
		System.out.println("BizAspect around 2.");
		System.out.println("BizAspect around return: " + obj);
		return obj;
	}

}

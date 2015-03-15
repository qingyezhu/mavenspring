package com.wangzhu.aop;

import java.math.BigInteger;

import org.perf4j.aop.Profiled;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrimeGenerator {
	private BigInteger currentPrime = new BigInteger("0");

	public void setCurrentPrime(BigInteger currentPrime) {
		this.currentPrime = currentPrime;
	}

	@Profiled
	public BigInteger nextPrime() {
		currentPrime = currentPrime.nextProbablePrime();
		return currentPrime;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring-aop.xml");
		PrimeGenerator primeGenerator = (PrimeGenerator) context
				.getBean("primeGenerator");
		System.out.println(primeGenerator.nextPrime());
	}

}

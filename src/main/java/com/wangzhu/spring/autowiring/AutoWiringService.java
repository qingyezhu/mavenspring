package com.wangzhu.spring.autowiring;

public class AutoWiringService {

	private String serviceName = "default-service";
	private AutoWiringDao autoWiringDao1;

	private AutoWiringService(String serviceName) {
		this.serviceName = serviceName;
	}

	private AutoWiringService() {
		System.out.println("�޲ι��췽��");
	}

	// private AutoWiringService(AutoWiringDao autoWiringDao3) {
	// autoWiringDao1 = autoWiringDao3;
	// System.out.println("�вι��췽��===" + autoWiringDao1.getDaoName());
	// }

	public void setAutoWiringDao1(AutoWiringDao autoWiringDao) {
		autoWiringDao1 = autoWiringDao;
	}

	public void say(String word) {
		System.out.println(serviceName);
		if (autoWiringDao1 != null) {
			autoWiringDao1.say(word);
		}
	}
}

package com.wangzhu.spring.autowiring;

public class AutoWiringDao {
	private String daoName;

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void say(String word) {
		System.out.println(daoName + "===AutoWiringDao===" + word);
	}

}

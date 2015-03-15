package com.wangzhu.spring.beanannotation.injection.dao;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDaoImpl implements InjectionDao {

	public void save(String arg) {
		System.out.println("InjectionDaoImpl save: " + arg);
	}

}

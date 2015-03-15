package com.wangzhu.spring.beanannotation.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangzhu.spring.beanannotation.injection.dao.InjectionDao;

@Service
public class InjectionServiceImpl implements InjectionService {

	// @Autowired
	private InjectionDao injectionDao;

	@Autowired
	private InjectionServiceImpl(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}

	// @Autowired
	public void setInjectionDao(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}

	public void save(String arg) {
		System.out.println("InjectionServiceImpl save: " + arg);
		arg = arg + ": " + this.hashCode();
		injectionDao.save(arg);
	}

}

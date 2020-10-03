package com.wangzhu.service.impl;

import com.wangzhu.service.IAllUserService;
import com.wangzhu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang.zhu on 2020-09-05 15:01.
 **/
@Service
public class AllUserServiceImpl implements IAllUserService {

    @Autowired
    private IUserService userService;

    @Override
    public void print() {
        userService.print();
    }
}

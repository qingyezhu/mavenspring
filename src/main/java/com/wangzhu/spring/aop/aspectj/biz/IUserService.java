package com.wangzhu.spring.aop.aspectj.biz;

import com.wangzhu.annotation.LogSwitch;

/**
 * Created by wangzhu on 2019/4/26 下午12:50.
 */
public interface IUserService {

    @LogSwitch(enabled = false)
    void queryUser(String id);
}

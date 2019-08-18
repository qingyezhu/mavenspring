package com.wangzhu.spring.aop.aspectj.biz;

import com.wangzhu.annotation.LogSwitch;
import org.springframework.stereotype.Service;

/**
 * Created by wangzhu on 2019/4/26 下午12:51.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
//    @LogSwitch (enabled = false)
    public void queryUser(String id) {
        System.out.println(System.currentTimeMillis() +"===" + id);
    }
}

package com.wangzhu.spring.aop.aspectj.biz;

import com.wangzhu.annotation.ProxyEventListener;
import com.wangzhu.annotation.ServiceProxy;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;

/**
 * Created by wangzhu on 2019/4/26 下午12:51.
 */
@ServiceProxy(value = "userProxy")
public class UserServiceImpl implements IUserService {
    @Override
//    @LogSwitch (enabled = false)
    public void queryUser(String id) {
        System.out.println(System.currentTimeMillis() +"===" + id);
    }

    @ProxyEventListener(clzss = {ContextClosedEvent.class, ContextStartedEvent.class})
    public void ap(ApplicationEvent applicationEvent){
        System.out.println(applicationEvent);
    }
}

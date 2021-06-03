package com.wangzhu.utils;

import com.wangzhu.strategy.ServiceTest2;
import com.wangzhu.strategy.bean.StrategyEnum;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by wang.zhu on 2021-05-26 18:28.
 **/
public class EnhancerTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY));
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceTest2.class);
        enhancer.setCallback(new CglibProxyIntercepter());

        ServiceTest2 serviceTest2 = (ServiceTest2)enhancer.create();
        serviceTest2.handlerHigh(StrategyEnum.HIGH);
        System.out.println(serviceTest2.getClass().getName());
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "");

    }
}

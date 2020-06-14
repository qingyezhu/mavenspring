package com.wangzhu.service;

import com.wangzhu.annotation.SelfBean;
import com.wangzhu.spring.scanv2.SelfComponent;

/**
 * Created by wang.zhu on 2020-06-12 15:40.
 **/
@SelfBean(name = "abc")
@SelfComponent("selfScanService")
public class SelfService {

    public void print() {
        System.out.println("timestamp: " + System.currentTimeMillis());
    }
}

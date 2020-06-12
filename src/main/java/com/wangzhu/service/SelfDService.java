package com.wangzhu.service;

import org.springframework.stereotype.Component;

/**
 * Created by wang.zhu on 2020-06-12 16:57.
 **/
@Component("selfdservice")
public class SelfDService {

    public void print() {
        System.out.println("SelfDService " + System.currentTimeMillis());
    }
}

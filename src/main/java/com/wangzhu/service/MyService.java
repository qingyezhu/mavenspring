package com.wangzhu.service;

/**
 * Created by wang.zhu on 2020-06-15 18:52.
 **/
public class MyService {
    private String url;
    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void print(){
        System.out.println(url + "====" + password);
    }
}

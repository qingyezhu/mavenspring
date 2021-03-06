package com.wangzhu.other.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wang.zhu on 2021-03-08 20:39.
 **/
public class Animal {
    private String id;
    private int age;

    static{
        System.out.println("animal static init");
    }

    Animal() {
    }

    public Animal(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

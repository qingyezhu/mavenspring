package com.wangzhu.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wangzhu on 2018/5/8 下午7:45.
 */
public class Cat extends Animal{
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

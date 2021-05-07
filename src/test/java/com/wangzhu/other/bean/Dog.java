package com.wangzhu.other.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by wang.zhu on 2021-03-08 20:39.
 **/
public class Dog extends Animal implements Serializable {
    //父类没有实现Serializable，那么父类需要提供一个无参的构造方法，并且子类能够访问到，否则即使子类实现了Serializable，也不能反序列化
    private String dotAction;

    public Dog(String id, int age, String dotAction) {
        super(id, age);
        this.dotAction = dotAction;
    }

    public String getDotAction() {
        return dotAction;
    }

    public void setDotAction(String dotAction) {
        this.dotAction = dotAction;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}


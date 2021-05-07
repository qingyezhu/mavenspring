package com.wangzhu.other.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wang.zhu on 2021-03-08 20:30.
 **/
public class Son extends Father {
    private String dotAction;

    private Son() {
        this(null, 1, "");
    }

    public Son(String id, int age, String dotAction) {
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

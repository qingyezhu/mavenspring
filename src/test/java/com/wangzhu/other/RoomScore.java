package com.wangzhu.other;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by wangzhu on 2018/6/3 下午10:27.
 */
public class RoomScore implements Serializable, Comparable<RoomScore> {

    private static final long serialVersionUID = -7877105403505384579L;
    private String cid;
    private Double score;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public int compareTo(RoomScore roomScore) {
        return roomScore.getScore().compareTo(this.getScore());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

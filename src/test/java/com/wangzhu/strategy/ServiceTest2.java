package com.wangzhu.strategy;

import com.wangzhu.strategy.bean.StrategyEnum;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by wang.zhu on 2020-05-16 08:39.
 **/
public class ServiceTest2 {

    public static void main(String[] args) {
        new ServiceTest2().test();
    }

    public void test() {
        final Map<StrategyEnum, Consumer<StrategyEnum>> map = new HashMap<>();
        map.put(StrategyEnum.NORMAL, this::handlerNormal);
        map.put(StrategyEnum.LOW, this::handlerLow);
        map.put(StrategyEnum.HIGH, this::handlerHigh);
        map.put(StrategyEnum.MEDIUM, this::handlerMedium);


        final StrategyEnum strategyEnum = StrategyEnum.MEDIUM;
        map.get(strategyEnum).accept(strategyEnum);
    }


    public void handlerNormal(StrategyEnum strategyEnum) {
        System.out.println("normal");
    }

    public void handlerLow(StrategyEnum strategyEnum) {
        System.out.println("low");
    }

    public void handlerHigh(StrategyEnum strategyEnum) {
        System.out.println("high");
    }

    public void handlerMedium(StrategyEnum strategyEnum) {
        System.out.println("medium");
    }

//
//    interface AA {
//        void handler(StrategyEnum strategyEnum);
//    }
}

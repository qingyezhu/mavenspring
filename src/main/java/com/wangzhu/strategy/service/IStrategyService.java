package com.wangzhu.strategy.service;

import com.wangzhu.strategy.bean.StrategyEnum;

public interface IStrategyService {
    StrategyEnum getCurrentStrategy();

    void handler(Long invokeId);
}

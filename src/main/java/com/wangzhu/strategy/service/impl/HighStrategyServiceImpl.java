package com.wangzhu.strategy.service.impl;

import com.wangzhu.strategy.bean.StrategyEnum;
import com.wangzhu.strategy.service.IStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HighStrategyServiceImpl implements IStrategyService {
    private static final Logger logger = LoggerFactory.getLogger(HighStrategyServiceImpl.class);

    @Override
    public StrategyEnum getCurrentStrategy() {
        return StrategyEnum.HIGH;
    }

    @Override
    public void handler(Long invokeId) {
        logger.info("detail high invokeId|{}", invokeId);
    }
}

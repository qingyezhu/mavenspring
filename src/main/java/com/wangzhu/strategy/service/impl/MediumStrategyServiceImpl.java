package com.wangzhu.strategy.service.impl;

import com.wangzhu.strategy.bean.StrategyEnum;
import com.wangzhu.strategy.service.IStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MediumStrategyServiceImpl implements IStrategyService {
    private static final Logger logger = LoggerFactory.getLogger(MediumStrategyServiceImpl.class);

    @Override
    public StrategyEnum getCurrentStrategy() {
        return StrategyEnum.MEDIUM;
    }

    @Override
    public void handler(Long invokeId) {
        logger.info("detail medium invokeId|{}", invokeId);
    }
}

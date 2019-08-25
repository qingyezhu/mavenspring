package com.wangzhu.strategy.service.impl;

import com.wangzhu.strategy.bean.StrategyEnum;
import com.wangzhu.strategy.service.IStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NormalStrategyServiceImpl implements IStrategyService {
    private static final Logger logger = LoggerFactory.getLogger(NormalStrategyServiceImpl.class);

    @Override
    public StrategyEnum getCurrentStrategy() {
        return StrategyEnum.NORMAL;
    }

    @Override
    public void handler(Long invokeId) {
        logger.info("detail normal invokeId|{}", invokeId);
    }
}

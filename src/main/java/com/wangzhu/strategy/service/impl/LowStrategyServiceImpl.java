package com.wangzhu.strategy.service.impl;

import com.wangzhu.strategy.bean.StrategyEnum;
import com.wangzhu.strategy.service.IStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("lowStrategyService")
public class LowStrategyServiceImpl implements IStrategyService {
    private static final Logger logger = LoggerFactory.getLogger(LowStrategyServiceImpl.class);

    @Override
    public StrategyEnum getCurrentStrategy() {
        return StrategyEnum.LOW;
    }

    @Override
    public void handler(Long invokeId) {
        logger.info("detail low invokeId|{}", invokeId);
    }
}

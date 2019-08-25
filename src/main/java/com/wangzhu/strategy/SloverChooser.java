package com.wangzhu.strategy;

import com.google.common.collect.Maps;
import com.wangzhu.strategy.bean.StrategyEnum;
import com.wangzhu.strategy.service.IStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SloverChooser implements ApplicationContextAware, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SloverChooser.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Map<StrategyEnum, IStrategyService> strategyServices = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        strategyServices = Maps.newHashMap();

        final Map<String, IStrategyService> strategyServiceMap = applicationContext.getBeansOfType(IStrategyService.class);

        for (final Map.Entry<String, IStrategyService> entry : strategyServiceMap.entrySet()) {
            final String key = entry.getKey();
            final IStrategyService strategyService = entry.getValue();
            //服务别名
            logger.info("detail key|{}|strategyService|{}", key, strategyService);
            strategyServices.put(strategyService.getCurrentStrategy(), strategyService);
        }
    }

    public IStrategyService choose(StrategyEnum strategyEnum){
        return strategyServices.get(strategyEnum);
    }
}

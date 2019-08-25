package com.wangzhu.strategy;

import com.wangzhu.spring.test.base.UnitTestBase;
import com.wangzhu.strategy.bean.StrategyEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ServiceTest extends UnitTestBase {

    public ServiceTest() {
        super("classpath*:spring-strategy.xml");
    }

    @Test
    public void test() {
        final SloverChooser sloverChooser = this.getBean(SloverChooser.class);
        System.out.println(sloverChooser);

        sloverChooser.choose(StrategyEnum.NORMAL).handler(System.currentTimeMillis());
        sloverChooser.choose(StrategyEnum.LOW).handler(System.currentTimeMillis());
        sloverChooser.choose(StrategyEnum.HIGH).handler(System.currentTimeMillis());
        sloverChooser.choose(StrategyEnum.MEDIUM).handler(System.currentTimeMillis());
    }
}

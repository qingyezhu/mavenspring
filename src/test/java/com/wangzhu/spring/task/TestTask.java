package com.wangzhu.spring.task;

import com.wangzhu.spring.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by wang.zhu on 2020-04-14 21:31.
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class TestTask extends UnitTestBase {
    public TestTask() {
        super("classpath:spring-task.xml");
    }

    @Test
    public void test() {
        try {
            Thread.sleep(60 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

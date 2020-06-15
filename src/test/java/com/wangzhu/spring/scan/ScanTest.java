package com.wangzhu.spring.scan;

import com.wangzhu.service.SelfService;
import com.wangzhu.spring.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by wang.zhu on 2020-06-14 18:17.
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class ScanTest extends UnitTestBase {
    public ScanTest() {
        super("classpath:spring-scan.xml");
    }

    @Test
    public void test1(){
        SelfService selfService = super.getBean(SelfService.class);
        selfService.print();

        try{
            Thread.sleep(10L);
        }catch (Exception e){
            e.printStackTrace();
        }
        selfService = (SelfService)super.getBean("selfScanService");
        selfService.print();
    }
}

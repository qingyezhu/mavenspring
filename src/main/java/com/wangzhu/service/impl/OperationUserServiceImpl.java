package com.wangzhu.service.impl;

import com.wangzhu.service.IOperationUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by wang.zhu on 2020-09-05 15:00.
 **/
@Service
public class OperationUserServiceImpl implements IOperationUserService {
    private static final Logger logger = LoggerFactory.getLogger(OperationUserServiceImpl.class);

    @Override
    public void print() {
        logger.info("timestamp: {}", System.currentTimeMillis());
    }
}

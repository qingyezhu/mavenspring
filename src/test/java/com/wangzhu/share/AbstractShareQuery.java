package com.wangzhu.share;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wangzhu on 2018/5/30 下午4:44.
 */
public abstract class AbstractShareQuery {

    private Integer shareNum;
    private List<String> shareItem;
    private ThreadPoolExecutor threadPoolExecutor;
    private Long timeout;

    public AbstractShareQuery(Integer shareNum, List<String> shareItem, ThreadPoolExecutor threadPoolExecutor, Long timeout) {
        this.shareNum = shareNum;
        this.shareItem = shareItem;
        this.threadPoolExecutor = threadPoolExecutor;
        this.timeout = timeout;
    }

    public abstract void callback(String hashKey, List<String> list);

    public void execute() throws Exception {
        final Map<Integer, List<String>> shareMap = toMap(shareItem, shareNum);
        final CountDownLatch countDownLatch = getCountDownLatch(shareMap.size());
        final AtomicBoolean end = new AtomicBoolean(false);
        for (Map.Entry<Integer, List<String>> shareEntry : shareMap.entrySet()) {
            final String hashKey = shareEntry.getKey().toString();
            final List<String> list = shareEntry.getValue();
            if (threadPoolExecutor != null) {
                this.threadPoolExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (end.get()) {
                                return;
                            }
                            callback(hashKey, list);
                        } finally {
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                        }
                    }
                });
            } else {
                callback(hashKey, list);
            }
        }
        if (countDownLatch != null) {
            try {
                if (timeout == 0) {
                    countDownLatch.await();
                } else {
                    countDownLatch.await(timeout, TimeUnit.MILLISECONDS);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                end.set(true);
            }
        }
    }

    protected CountDownLatch getCountDownLatch(int size) {
        if (timeout != null && timeout >= 0) {
            return new CountDownLatch(size);
        }
        return null;
    }

    protected Map<Integer, List<String>> toMap(final List<String> list, final int num) {
        final Map<Integer, List<String>> results = Maps.newHashMapWithExpectedSize(list.size());
        for (String item : list) {
            final Integer val = Integer.parseInt(item) % num;
            List<String> valList = results.get(val);
            if (valList == null) {
                valList = new ArrayList<>();
                results.put(val, valList);
            }
            valList.add(item);
        }
        return results;
    }

}

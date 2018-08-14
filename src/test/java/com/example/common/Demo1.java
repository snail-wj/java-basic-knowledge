package com.example.common;

import org.junit.Test;

/**
 * @author WJ
 * @date 2018/8/13
 */
public class Demo1 {

    /**
     * 测试方法所有的耗时
     */
    @Test
    public void testDuration() throws InterruptedException {
        final long startTimestamp = System.currentTimeMillis();
        //要测试的方法
        for(int i = 0; i <10; i++){
            Thread.sleep((long)(Math.random() * 100));
        }
        System.out.println(System.currentTimeMillis() - startTimestamp);
        //一般我们采用的是打日志
        //LOGGER.debug("xxxx:{}"，System.currentTimeMillis() - startTimestamp)
    }
}

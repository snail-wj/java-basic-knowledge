package com.example.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author WJ
 * @date 2018/8/12
 *
 * Semaphore(信号量)的使用
 */
public class SemaPhoreDemo {

    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只能同时有5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {

                @Override
                public void run() {
                    //获取许可
                    try {
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 6000));
                        //访问完后，释放
                        semp.release();
                        //availablePermits()指的是当前信号灯库中有多少个可以使用
                        System.out.println("------------------" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        //退出线程池
        exec.shutdown();
    }
}

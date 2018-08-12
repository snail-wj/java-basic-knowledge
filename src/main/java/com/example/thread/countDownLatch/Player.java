package com.example.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author WJ
 * @date 2018/8/12
 */
public class Player implements Runnable {

    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;

    Player(int id, CountDownLatch begin, CountDownLatch end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            begin.await();
            Thread.sleep((long)(Math.random() * 100) * 100);
            System.out.println("play" + id + " arrived.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }
}

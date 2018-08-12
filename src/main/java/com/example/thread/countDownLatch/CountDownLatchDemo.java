package com.example.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WJ
 * @date 2018/8/12
 *
 * 介绍CountDownLatch是什么
 * CountDownLatch可以控制线程的执行，他可以让所有持有他的多个线程同时执行，也可以控制单个线程执行。
 * 他初始化的时候会传出一个int类型的参数i，调用一次countDown(）方法后i的值会减1。
 * 在一个线程中如果调用了await()方法，这个线程就会进入到等待的状态，当参数i为0的时候这个线程才继续执行。
 *
 * 题目:
 *  比如一个跑步比赛，有五个选手参加，有两点需要注意，第一我们必须确保这5个选手都准备就绪了，才能宣布比赛开始，第二只有当5个选手都完成比赛了才能宣布比赛结束。
 *
 * 参考url:
 *  https://blog.csdn.net/u013136708/article/details/49444459
 */
public class CountDownLatchDemo {
    private static final int PLAYER_AMOUNT = 5;

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);
        Player[] players = new Player[PLAYER_AMOUNT];

        for (int i = 0; i < PLAYER_AMOUNT; i++) {
            players[i] = new Player(i, begin, end);
        }

        ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for (Player p : players) {
            exe.execute(p);
        }
        System.out.println("Race begin!");
        begin.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Race ends !");
        }
        exe.shutdown();
    }
}

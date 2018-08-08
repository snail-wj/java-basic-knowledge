package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author WJ
 * @date 2018/08/08
 *
 * 通过Callable和Future创建线程
 *
 * 步骤:
 * 1.创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
 * 2.创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值
 * 3.使用FutureTask对象作为Thread对象的target创建并启动新线程。
 * 4.调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
 */
public class CallableThreadTest implements Callable<Integer> {

    /**
     * 这个是一个共享的变量
     */
    private int i = 0;

    public static void main(String[] args) {

        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-------------->" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程1").start();
                new Thread(ft, "有返回值的线程2").start();
            }
        }
        try {
            System.out.println("子线程的返回值:" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程的执行体
     *
     * @return 返回T类型的值
     */
    @Override
    public Integer call() {

        for (; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-------------->" + i);
        }
        return i;
    }
}

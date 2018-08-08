package com.example.thread;

/**
 * @author WJ
 * @date 2018/08/08
 * 继承Thread类创建线程类
 *
 * 步骤：
 *  1.定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。因此把run()方法称为执行体。
 *  2.创建Thread子类的实例，即创建了线程对象。
 *  3.调用线程对象的start()方法来启动该线程。
 *
 */
public class FirstThreadTest extends Thread {

    /**
     * 如果使Thread里面的常量是共享的，如果是static，则是共享的，否则只是在一个线程里面
     */
    private static int i = 0;

    /**
     * 重写run方法，run方法就是线程的执行体
     */
    @Override
    public void run() {
        for (; i < 100; i++) {
            try {
               Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "-------------->" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-------------->" + i);
            if(i == 20){
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }
}

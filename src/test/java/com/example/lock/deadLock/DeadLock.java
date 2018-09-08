package com.example.lock.deadLock;

/**
 * @author WJ
 * @date 2018/09/08
 */
public class DeadLock implements Runnable {

    private boolean flag;
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag){
            synchronized (object1){
                try {
                    System.out.println(Thread.currentThread().getName() + " if....");
                    Thread.sleep(1000);
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName() + " if....");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            synchronized (object2){
                try {
                    System.out.println(Thread.currentThread().getName() + " else....");
                    Thread.sleep(1000);
                    synchronized (object1){
                        System.out.println(Thread.currentThread().getName() + " else....");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock lock1 = new DeadLock(false);
        DeadLock lock2 = new DeadLock(true);
        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock2);
        t1.start();
        t2.start();
    }
}

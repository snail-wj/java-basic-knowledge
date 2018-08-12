package com.example.thread.cyclicBarrier;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WJ
 * @date 2018/8/12
 * CyclicBarrier：当计数达到指定的值时，计数置为0，重新开始，
 * 所以文中一下代码是3个，并且线程一定要是3的倍数，否则，会阻塞一部分线程的执行
 */
public class Race {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    private static void start(){
        System.out.println(cyclicBarrier.getNumberWaiting());
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete(cyclicBarrier, "博尔特"));
        athletes.add(new Athlete(cyclicBarrier, "鲍威尔"));
        athletes.add(new Athlete(cyclicBarrier, "盖伊"));
        athletes.add(new Athlete(cyclicBarrier, "布雷克"));
        athletes.add(new Athlete(cyclicBarrier, "加特林"));
        athletes.add(new Athlete(cyclicBarrier, "苏炳添"));
        athletes.add(new Athlete(cyclicBarrier, "路人甲"));
        athletes.add(new Athlete(cyclicBarrier, "路人乙"));
        athletes.add(new Athlete(cyclicBarrier, "路人丙"));
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Athlete athlete : athletes){
            executor.execute(athlete);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        start();
    }
}

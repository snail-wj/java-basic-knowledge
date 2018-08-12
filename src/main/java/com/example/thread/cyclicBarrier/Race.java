package com.example.thread.cyclicBarrier;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WJ
 * @date 2018/8/12
 */
public class Race {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(8);

    private static void start(){
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete(cyclicBarrier, "博尔特"));
        athletes.add(new Athlete(cyclicBarrier, "鲍威尔"));
        athletes.add(new Athlete(cyclicBarrier, "盖伊"));
        athletes.add(new Athlete(cyclicBarrier, "布雷克"));
        athletes.add(new Athlete(cyclicBarrier, "加特林"));
        athletes.add(new Athlete(cyclicBarrier, "苏炳添"));
        athletes.add(new Athlete(cyclicBarrier, "路人甲"));
        athletes.add(new Athlete(cyclicBarrier, "路人乙"));
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (Athlete athlete : athletes){
            executor.execute(athlete);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        start();
    }
}

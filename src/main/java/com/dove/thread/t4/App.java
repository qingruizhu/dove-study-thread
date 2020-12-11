package com.dove.thread.t4;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 16:23
 */
public class App {


    public static void main(String[] args) {
        int task = 10;
        CyclicBarrier barrier = new CyclicBarrier(task, () -> {
            System.out.println("----->" + Thread.currentThread().getName() + "<-------");
        });
        ExecutorService pool = Executors.newFixedThreadPool(task);
        for (int i = 1; i <=task ; i++) {
            pool.execute(new Go("【"+i+"】号小工", barrier));
        }
        pool.shutdown();
    }


}

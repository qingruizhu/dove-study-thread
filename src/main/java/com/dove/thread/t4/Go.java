package com.dove.thread.t4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 16:31
 */
public class Go implements Runnable {
    private String name;
    private CyclicBarrier barrier;

    public Go(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(this.name+"--->打地基...");
        try {
            Thread.sleep(1000);
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"--->建围墙...");
        try {
            Thread.sleep(1000);
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"--->盖屋顶...");
    }
}

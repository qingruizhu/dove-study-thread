package com.dove.thread.t3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 15:40
 */
public class Woker implements Runnable {
    private String name;
    private CountDownLatch downLatch;

    public Woker(String name, CountDownLatch downLatch) {
        this.name = name;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        this.doSomething();
        try {
            Thread.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " 干完活了！");
        this.downLatch.countDown();
    }

    public void doSomething() {
        System.out.println(this.name + "  正在干活....");
    }
}

package com.dove.thread.t3;

import java.util.concurrent.*;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 15:47
 */
public class App {
    public static void main(String[] args) {
        ExecutorService poll = Executors.newFixedThreadPool(2);
        CountDownLatch downLatch = new CountDownLatch(3);
        Woker 小明 = new Woker("小明", downLatch);
        Woker 小红 = new Woker("小红", downLatch);
        Woker 小黑 = new Woker("小黑", downLatch);
        Boss boss = new Boss(downLatch);
        poll.execute(boss);
        poll.execute(小明);
        poll.execute(小红);
        poll.execute(小黑);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        poll.shutdown();
        System.out.println("zzzz");

    }
}

package com.dove.thread.t3;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 15:40
 */
public class Boss implements Runnable {
    private CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("老板 -> 等着验收工作呢.....");
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("老板 -> 所有的工作已经完成！");
    }

}

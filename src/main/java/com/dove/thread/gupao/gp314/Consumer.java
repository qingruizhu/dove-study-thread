package com.dove.thread.gupao.gp314;

import java.util.Queue;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/11/21 14:32
 */
public class Consumer implements Runnable {

    private Queue<String> queue;
    private int maxSize;

    public Consumer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ",等待前:" + i);
                        queue.wait();
                        System.out.println(Thread.currentThread().getName() + ",等待后:" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费消息:" + queue.remove());
                queue.notify();
            }
        }


    }
}

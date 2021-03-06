package com.dove.thread.gupao.gp314;

import java.util.Queue;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/11/21 14:32
 */
public class Producter implements Runnable {

    private Queue<String> queue;
    private int maxSize;

    public Producter(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (queue) {
                while (queue.size() == maxSize) {
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
                System.out.println("生产消息:" + i);
                queue.add("你好啊[" + i + "]");
                queue.notify();
            }
        }


    }
}

package com.dove.thread.t8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/7 17:14
 */
public class Ticket implements Runnable {

    private int ticket;
    private Lock lock = new ReentrantLock();

    public Ticket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            try {
            System.out.println(Thread.currentThread().getName()+"-> 准备获取锁");
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"--> 获取锁");
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "------------>出售第[" + ticket-- + "]张票");
            } else {
                return;
            }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"----> 释放锁");
            }
        }
    }
}

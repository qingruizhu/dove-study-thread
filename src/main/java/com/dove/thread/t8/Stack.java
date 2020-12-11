package com.dove.thread.t8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁及其同步条件来实现一个生产者-消费者模型：
 */
public class Stack {
    private int max;
    private Lock lock = new ReentrantLock();
    private Condition write = lock.newCondition();
    private Condition read = lock.newCondition();
    private LinkedList<String> messages;

    public Stack(int max) {
        this.max = max;
        this.messages = new LinkedList<>();
    }

    public void set(String message) {
        lock.lock();
        try {
            while (messages.size() >= max) {
                System.out.println("the message buffer is full now,start into wait()");
                write.await();//当前线程休眠队列，并且释放锁
                System.out.println("唤醒 -> " + Thread.currentThread().getName());
            }
            Thread.sleep(1000);
            messages.add(message);
            System.out.print("add message:" + message + " success\n");
            read.signalAll();//唤醒读取线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        lock.lock();
        String message = null;
        try {
            while (messages.size() <= 0) {
                System.out.println("the message buffer is empty now,start into wait()");
                read.await();
                System.out.println("唤醒 -> " + Thread.currentThread().getName());
            }
            Thread.sleep(1000);
            message = messages.poll();
            System.out.print("get message:" + message + " success\n");
            write.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return message;
    }
}

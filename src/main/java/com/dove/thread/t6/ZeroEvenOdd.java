package com.dove.thread.t6;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/5 22:08
 */
public class ZeroEvenOdd {

    private int n;
    Semaphore semaphore0 = new Semaphore(1);
    Semaphore semaphore1 = new Semaphore(2);
    Semaphore semaphore2 = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore0.acquire();
            printNumber.accept(0);
            semaphore1.release();
            semaphore2.release();
        }
    }

    /**
     * 偶数
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphore2.acquire(3);

            printNumber.accept(i);
            semaphore0.release();
            semaphore1.release();
        }
    }

    /**
     * 奇数
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphore1.acquire(3);

            printNumber.accept(i);
            semaphore2.release();
            semaphore0.release();
        }
    }
}

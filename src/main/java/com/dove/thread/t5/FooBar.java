package com.dove.thread.t5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FooBar {

    private int n = 20;
    private CountDownLatch downLatch;
    private CyclicBarrier barrier;

    FooBar(int n) {
        this.n = n;
        downLatch = new CountDownLatch(1);
        barrier = new CyclicBarrier(2,()->{
            this.downLatch = new CountDownLatch(1);
            System.out.println("------> 恢复计数器 "+downLatch.getCount());
        });
    }

    public void foo(Runnable runnable) {
        for (int i = 0; i < n; i++) {
            runnable.run();
            downLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
//            System.out.println("foo");
        }
    }

    public void bar(Runnable runnable) {
        for (int i = 0; i < n; i++) {
            try {
                downLatch.await();
                runnable.run();
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

//            System.out.println("bar");
        }
    }


}

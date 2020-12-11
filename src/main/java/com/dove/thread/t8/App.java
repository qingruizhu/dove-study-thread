package com.dove.thread.t8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/7 17:14
 */
public class App {

    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        Ticket ticket = new Ticket(10);
//        pool.execute(ticket);
//        pool.execute(ticket);
//        pool.execute(ticket);
//        pool.shutdown();


        ExecutorService pool = Executors.newFixedThreadPool(2);
        Stack stack = new Stack(5);
        new Thread(() -> {
            while (true) {
                stack.set("你好");
            }
        }, "添加线程").start();
        new Thread(() -> {
            while (true) {
                System.out.println(stack.get());
            }
        }, "获取线程").start();
    }
}

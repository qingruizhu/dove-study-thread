package com.dove.thread.t6;


/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/5 22:10
 */
public class App {

    public static void main(String[] args) {
        ZeroEvenOdd odd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                odd.zero((value) -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                odd.even((value) -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                odd.odd((value) -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

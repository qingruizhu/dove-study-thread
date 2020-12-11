package com.dove.thread.t1;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 00:14
 */
public class App {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(new T2(foo)).start();
        new Thread(new T3(foo)).start();
        new Thread(new T1(foo)).start();



    }
}

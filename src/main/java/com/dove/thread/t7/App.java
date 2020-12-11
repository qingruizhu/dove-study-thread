package com.dove.thread.t7;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 
 *          
 * @Author qingruizhu
 * @Date 2:59 下午 2020/4/7
 * @Param 
 * @return 
 **/
public class App {

    public static void main(String[] args) {
        H2O h2O = new H2O();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 100; i++) {
            pool.execute(()->{
                try {
                    h2O.h(()->{
                        System.out.print("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            if (i != 1 && i % 2 == 0) {
                pool.execute(()->{
                    try {
                        h2O.o(()->{
                            System.out.print("O");
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        pool.shutdown();

    }
}

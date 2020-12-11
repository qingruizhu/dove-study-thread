package com.dove.thread.gupao.gp314;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/11/21 14:42
 */
public class Test {


    public static void main(String[] args) {


        Queue queue = new LinkedList<String>();
        int maxSize = 10;

        new Thread(new Consumer(queue, maxSize), "消费线程").start();
        new Thread(new Producter(queue, maxSize), "生产线程").start();
    }
}

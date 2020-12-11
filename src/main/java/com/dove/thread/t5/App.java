package com.dove.thread.t5;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/5 19:28
 */
public class App {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(20);

        new Thread(()->{
            fooBar.foo(()->{
                System.out.print("Foo");
            });
        }).start();
        new Thread(()->{
            fooBar.bar(()->{
                System.out.print("Bar");
            });
        }).start();

    }
}

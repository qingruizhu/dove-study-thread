package com.dove.thread.t1;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 00:14
 */
public class T2 implements Runnable {
    private Foo foo;

    public T2(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        while (foo.cut != 1) {

        }
        foo.two();
    }
}

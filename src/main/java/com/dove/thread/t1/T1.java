package com.dove.thread.t1;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 00:14
 */
public class T1 implements Runnable {
    private Foo foo;

    public T1(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
//        while (foo.cut != 0) {
//        }
        foo.one();
    }
}

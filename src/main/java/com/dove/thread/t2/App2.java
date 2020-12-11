package com.dove.thread.t2;


/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/4 00:14
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
        final Foo foo = new Foo();

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    foo.first(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println("1....");
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println("1.....");

                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println("2....");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.println("3...");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread3.start();
    }
}

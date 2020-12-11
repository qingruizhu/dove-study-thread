package com.dove.thread.t7;

import java.util.concurrent.Semaphore;

/**
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H2O {

    private Semaphore hSm = new Semaphore(2);
    private Semaphore oSm = new Semaphore(0);

//    public H2O(Semaphore hSm, Semaphore oSm) {
//        this.hSm = hSm;
//        this.oSm = oSm;
//    }

    /**
     * 输出h
     */
    public void h(Runnable task) throws InterruptedException {
        hSm.acquire();//消耗一个h的信号
        task.run();
        oSm.release();//释放一个o的信号
    }

    /**
     * 输出 o
     */
    public void o(Runnable task) throws InterruptedException {
        oSm.acquire(2);//消耗两个o的信号
        task.run();
        hSm.release(2);//释放两个h的信号
    }

}

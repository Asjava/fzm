package com.fxs.fzm.concurrent.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * new ReentrantLock(true) 公平锁， 默认是非公平的。
 * 公平锁相对性能比较低，内部还需维护队列信息。
 * 
 * lock()
 * tryLock()
 *lockInterruptibly()
 * tryLock(long time, TimeUnit unit)
 * unlock()
 *
 * @author: fuzhm
 */
public class FairLock implements Runnable {
    public  static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock1 = new FairLock();
        FairLock fairLock2 = new FairLock();
        Thread t1 = new Thread(fairLock1, "Thread1");
        Thread t2 = new Thread(fairLock2, "Thread2");

        t1.start();
        t2.start();
    }
}

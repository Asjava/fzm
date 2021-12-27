package com.fxs.fzm.concurrent.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: ReentrantLock 的相应中断方法lockInterruptibly()
 * Description:
 * Copyright: Copyright (c) 2020-09-25
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ReentrantLockInterruptiblyDemo implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    public int lock;

    public ReentrantLockInterruptiblyDemo(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ": 线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInterruptiblyDemo r1 = new ReentrantLockInterruptiblyDemo(1);
        ReentrantLockInterruptiblyDemo r2 = new ReentrantLockInterruptiblyDemo(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        Thread.sleep(1000);
//        t2.interrupt();
    }
}

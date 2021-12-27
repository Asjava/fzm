package com.fxs.fzm.concurrent.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: tryLock(5, TimeUnit.SECONDS)
 * Description:
 * Copyright: Copyright (c) 2020-09-25
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ReentrantLockTryLockDemo implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    public int lock;

    public ReentrantLockTryLockDemo(int lock) {
        this.lock = lock;
    }

//    @Override
//    public void run() {
//        if (lock == 1) {
//            while (true) {
//                if (lock1.tryLock()) {
//                    try {
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                        }
//                        if (lock2.tryLock()) {
//                            try {
//                                System.out.println(Thread.currentThread().getId() + ":My Job done");
//                                return;
//                            } finally {
//                                lock2.unlock();
//                            }
//                        }
//                    } finally {
//                        lock1.unlock();
//                    }
//                }
//            }
//        } else {
//            while (true) {
//                if (lock2.tryLock()) {
//                    try {
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                        }
//                        if (lock1.tryLock()) {
//                            try {
//                                System.out.println(Thread.currentThread().getId() + ":My Job done");
//                                return;
//                            } finally {
//                                lock1.unlock();
//                            }
//                        }
//                    } finally {
//                        lock2.unlock();
//                    }
//                }
//            }
//        }
//    }
    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {

                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + ":My job done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }

                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + ":My Job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }

                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTryLockDemo r1 = new ReentrantLockTryLockDemo(1);
        ReentrantLockTryLockDemo r2 = new ReentrantLockTryLockDemo(2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    
}

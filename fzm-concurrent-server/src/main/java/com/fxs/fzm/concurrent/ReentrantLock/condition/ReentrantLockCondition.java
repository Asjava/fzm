package com.fxs.fzm.concurrent.ReentrantLock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 *
 * void await()
 * void awaitUninterruptibly()
 * long awaitNacos(long nanosTimeout)
 * boolean await(long time, TimeUnit unit)
 * boolean awaitUntil(Date deadline)
 * void singnal()
 * void singnalAll()
 *
 * @author: fuzhm
 */
public class ReentrantLockCondition implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCondition r1 = new ReentrantLockCondition();
        Thread t1 = new Thread(r1);
        t1.start();

        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}

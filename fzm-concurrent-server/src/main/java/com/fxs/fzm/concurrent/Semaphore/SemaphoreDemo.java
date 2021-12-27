package com.fxs.fzm.concurrent.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 *semaphore.acquire();
 *semaphore.acquireUninterruptibly();
 *semaphore.tryAcquire();
 *semaphore.tryAcquire(10, TimeUnit.MILLISECONDS);
 *semaphore.release();
 *
 * @author: fuzhm
 */
public class SemaphoreDemo implements Runnable{
    public static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo s1 = new SemaphoreDemo();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            exec.submit(s1);
        }
    }

}

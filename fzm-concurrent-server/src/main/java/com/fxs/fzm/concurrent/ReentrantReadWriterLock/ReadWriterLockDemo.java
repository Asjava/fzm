package com.fxs.fzm.concurrent.ReentrantReadWriterLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ReadWriterLockDemo{
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriterLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriterLock.readLock();
    private static Lock writerLock = readWriterLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int value) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            this.value = value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        long startTime= System.currentTimeMillis();
        ReadWriterLockDemo demo = new ReadWriterLockDemo();
        Runnable readRunnable = new Runnable(){
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writerRunnable = new Runnable(){
            @Override
            public void run() {
                try {
                    demo.handleWrite(writerLock, new Random().nextInt());
//                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        List<Thread> tList= new ArrayList<Thread>();

        for (int i = 0; i < 18; i++) {
            Thread thread = new Thread(readRunnable);
            thread.start();
            tList.add(thread);
        }

        for (int i = 18; i < 20; i++) {
            Thread thread = new Thread(writerRunnable);
            thread.start();
            tList.add(thread);
        }

        for (Thread t1 : tList) {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + "s");
    }
}

package com.fxs.fzm.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Title:
 * new AtomicInteger();
 * new AtomicReference<>();
 * <p>
 * Description:
 * Copyright: Copyright (c) 2020-09-29
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++) {
            Thread t = new Thread(new AddThread());
            threads[j] = t;
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(i);
        AtomicReference<String> stringAtomicReference = new AtomicReference<>();
    }









}

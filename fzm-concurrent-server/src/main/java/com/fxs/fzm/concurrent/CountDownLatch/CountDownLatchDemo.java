package com.fxs.fzm.concurrent.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class CountDownLatchDemo implements Runnable {
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            exec.submit(countDownLatchDemo);
        }

        countDownLatch.await();

        System.out.println("Fire!");
        exec.shutdown();
    }

}

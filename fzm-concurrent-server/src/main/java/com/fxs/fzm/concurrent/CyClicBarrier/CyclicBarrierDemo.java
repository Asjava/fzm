package com.fxs.fzm.concurrent.CyClicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Title:CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrerRun(flag, n));
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String soldierName;

        public Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldierName = soldierName;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                dowork();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void dowork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldierName + "任务完成");
        }
    }

    public static class BarrerRun implements Runnable {
        public boolean flag;
        public int n;

        public BarrerRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵"+n +"个， 任务完成]");
            } else {
                System.out.println("司令：[士兵"+n +"个， 集结完毕]");
                flag = true;
            }
        }
    }



    public static void main(String[] args) {
        int n = 10;
        Thread[] threads = new Thread[n];
        boolean flag = false;

        // 创建cyclicBarrier对象
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrerRun(flag, n));

        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            System.out.println("士兵：" + i + " 报道");
            threads[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            threads[i].start();
            if (i == 5) {
                threads[0].interrupt();
            }
        }

    }
}

package com.fxs.fzm.concurrent.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class LockSupportDemo {
    public static Object u = new  Object();

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run () {
            synchronized (u) {
                System.out.println("in " +getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + " 被中断了");
                }
            }
            System.out.println(getName() + "执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread("t1");
        ChangeObjectThread t2 = new ChangeObjectThread("t2");

        t1.start();
        Thread.sleep(100);
        t2.start();

        t1.interrupt();
//        LockSupport.unpark(t1);
        LockSupport.unpark(t2);

        t1.join();
        t2.join();


    }
}

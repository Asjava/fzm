package com.fxs.fzm.concurrent.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title:  扩展线程池，在线程执行前后打印信息
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ExtThreadPool extends ThreadPoolExecutor{

    public ExtThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static class Mytask implements Runnable{
        public String name;

        public Mytask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("正在执行" + "Thread id:" + Thread.currentThread().getId() + ", Task Name=" + name);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("准备执行： " + ((Mytask)r).name);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("执行完成： " + ((Mytask)r).name);
    }

    @Override
    protected void terminated() {
        System.out.println("线程池退出");
    }

    public static void main(String[] args) throws InterruptedException {
        ExtThreadPool es = new ExtThreadPool(5, 5,
                0L, TimeUnit.MILLISECONDS,
                  new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            Mytask mytask = new Mytask("task-geym-" + i);
            es.execute(mytask);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}

package com.fxs.fzm.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * 线程池相关对象
 *      ExecutorService executorService = Executors.newFixedThreadPool(100);
 *      ExecutorService executorService1 = Executors.newSingleThreadExecutor();
 *      ExecutorService executorService2 = Executors.newCachedThreadPool();
 *      ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
 *      ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(2);
 *
 *
 * @author: fuzhm
 */
public class ThreadPoolDemo {

    public void threadPool() {
//        new ThreadPoolExecutor(Integer.MAX_VALUE, Integer.MAX_VALUE, new BlockingQueue<>(),)
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(2);

        //java8中特有，队列线程，线程执行完后会往队列扔数据
        CompletionService executorCompletionService = new ExecutorCompletionService<>(executorService);

        new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
        });

    }
}

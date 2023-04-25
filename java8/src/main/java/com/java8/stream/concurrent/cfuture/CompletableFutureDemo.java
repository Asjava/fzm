package com.java8.stream.concurrent.cfuture;

import java.util.concurrent.*;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2022-10-18 10:31
 * Company: 厦门船顺科技有限公司
 *
 * @author: fuzhm
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
//        CompletionService service = new ExecutorCompletionService<String>(Executors.newFixedThreadPool(20));
//        service.take();

//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double distictPrice = new Shop(10, 0.8).getDistictPrice();
//                futurePrice.complete(distictPrice);
//            } catch (Exception e) {
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        try {
//            System.out.println(futurePrice.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> 20d);

        // 等待上个线程执行完，执行该方法(同步执行)
//        CompletableFuture.supplyAsync(() -> 20d).thenApply(future-> future.doubleValue());

        // 自定义线程池调用、默认是ForkJoin线程池
        CompletableFuture.supplyAsync(()-> 20, Executors.newCachedThreadPool());

        // 异步执行
        CompletableFuture.supplyAsync(() -> 20d).thenCompose(future-> CompletableFuture.supplyAsync(()-> future*2));

        // 两个异步结果合并处理
        Future<Double> future = CompletableFuture.supplyAsync(() -> 20.01d).thenCombine(CompletableFuture.supplyAsync(() -> 2), (price, rate) -> price * rate);
        System.out.println(future.get());


    }



}

package com.fxs.fzm.concurrent.threadPool;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;

public class CompleteFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() ->{
            println("第一步返回\"Hello\"");
            return "Hello";
        }).thenApply(result ->{
            println("第二步在第一步返回\",World\"");
            return result + ".World";
        }).thenAccept(CompleteFutureDemo::println)
        .join();
    }

    private static void println(String message){
        System.out.printf("[线程: %s] %s\n", Thread.currentThread().getName(),message);

    }
}

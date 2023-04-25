package com.java8.stream.concurrent.cfuture;

import lombok.Data;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Data
public class RandomProduct {

    private String product;

    public RandomProduct(String product) {
        this.product = product;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public CompletableFuture<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public void delay() {
//        int delayTime = 500 + new Random().nextInt(2000);
        int delayTime = 1000;
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<RandomProduct> products = Arrays.asList(new RandomProduct("Basketball"),
                new RandomProduct("football"),
                new RandomProduct("pingpong")
        );

        // 并行流方式调用
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> priceList = products.parallelStream().map(product -> String.format("%s price is %.2f", product.getProduct(), product.getPrice(product.getProduct())))
                .collect(Collectors.toList());
        System.out.println(priceList);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        // 并行调用
        stopWatch.start();
        List<CompletableFuture<String>> futurePrice = products.stream().map(product -> CompletableFuture.supplyAsync(() ->
                String.format("%s price is %.2f", product.getProduct(), product.getPrice(product.getProduct())))).collect(Collectors.toList());
        List<String> collect = futurePrice.stream().map(CompletableFuture::join).collect(Collectors.toList());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

}

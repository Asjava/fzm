package com.java8.stream.concurrent.threadLocal;

import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalDemo {

    public static ThreadLocal<Integer> THREADLOCAL_A = new ThreadLocal<>();
    public static ThreadLocal<Integer> THREADLOCAL_B = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        THREADLOCAL_A.set(1);
        THREADLOCAL_B.set(1);

        new Thread(()-> {
            System.out.println(THREADLOCAL_A.get());
        }).start();

        new Thread(()-> {
            System.out.println(THREADLOCAL_B.get());
        }).start();

        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

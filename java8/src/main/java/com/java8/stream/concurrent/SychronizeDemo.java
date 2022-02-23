package com.java8.stream.concurrent;

import com.java8.stream.design.filter.AuthenticationFilter;

public class SychronizeDemo {

    public synchronized void doDemo1() {
        System.out.println("demo 1 执行");
        demo2();
    }

    public void demo2() {
        synchronized (AuthenticationFilter.filter) {
            System.out.println("demo 2 执行");
        }
    }

    public static void main(String[] args) {
        SychronizeDemo sychronizeDemo = new SychronizeDemo();
        sychronizeDemo.doDemo1();
    }
}

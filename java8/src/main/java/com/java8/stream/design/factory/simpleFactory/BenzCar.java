package com.java8.stream.design.factory.simpleFactory;

public class BenzCar implements Car{
    @Override
    public void run() {
        System.out.println("我是奔驰汽车，我在路上跑");
    }

    public static void main(String[] args) {
        int a = 1 << 3;
        int b = 24 >> 3;
        System.out.println(a);
        System.out.println(b);
    }
}

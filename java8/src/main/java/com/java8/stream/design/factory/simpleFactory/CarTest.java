package com.java8.stream.design.factory.simpleFactory;

public class CarTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Car car = CarFactory.getInstance();
        car.run();
    }
}

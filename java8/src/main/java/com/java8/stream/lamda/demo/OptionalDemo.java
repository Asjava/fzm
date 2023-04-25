package com.java8.stream.lamda.demo;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Car car = new Car();
        Optional<Car> empty = Optional.empty();

        Optional<Car> car1 = Optional.of(car);

        Optional<Car> car2 = Optional.ofNullable(car);


    }
}

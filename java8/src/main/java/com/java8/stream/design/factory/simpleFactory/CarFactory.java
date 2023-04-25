package com.java8.stream.design.factory.simpleFactory;

import java.io.IOException;
import java.util.Properties;

public class CarFactory {

    private CarFactory() {

    }

    private static Properties prop = new Properties();
    static {
        try {
            prop.load(CarFactory.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String carClassName = prop.getProperty("Car");
        Class<Car> carClass = (Class<Car>) Class.forName(carClassName);
        Car car = carClass.newInstance();
        return car;
    }
}

package com.java8.stream.design.factory.simpleFactory.newInstance;

public class FactoryTest {
    public static void main(String[] args) {
        EsFactory instance = EsFactory.getInstance();
        instance.getColumn();
    }
}

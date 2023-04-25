package com.java8.stream.design.single;

public class LazySingle {
    private static volatile LazySingle instance = null;


    private LazySingle() {

    }

    public static LazySingle getInstance() {
        if (instance == null) {
            synchronized (LazySingle.class) {
                if (instance == null) {
                    instance = new LazySingle();
                }
            }
        }
        return instance;
    }
}

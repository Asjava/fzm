package com.java8.stream.design.factory.simpleFactory.newInstance;

public abstract class EsFactory {
    private EsFactory(){

    }

    public abstract void getColumn();

    public static EsFactory getInstance() {
        return new Column1();
    }

    private static class Column1 extends EsFactory{

        @Override
        public void getColumn() {
            System.out.println("方法1执行");
        }
    }

    private static class Column2 extends EsFactory{

        @Override
        public void getColumn() {
            System.out.println("方法2执行");
        }
    }
}

package com.fxs.fzm.bean;

public class Transaction {
    private String name;
    private boolean open = false;
    private int count = 0; //记录食物被几个上层方法调用

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void begin() {
        open = true;
        System.out.println(name + "事物开始");
    }

    public void rollback() {
        System.out.println(name + "事物回滚");
    }

    public void commit() {
        System.out.println(name + "事物提交");
        open = false;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }
    public int getCount() {
        return count;
    }

    public static enum PROGATATION{
        NEW,REQUIRED;
    }
}

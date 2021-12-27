package com.java8.stream.InnerClass;

public class PrivateInnerClass {
    private int money;
    private String masterName;

    public PrivateInnerClass(int money, String masterName) {
        this.money = money;
        this.masterName = masterName;
    }

    private class Servant {
        private String name;
        private int age;

        public void said() {
            System.out.println("I'am " + this.name);
            System.out.println("My Master is " + masterName);
            System.out.println("My Master has " + money + " money");
        }

        public Servant(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private Servant servant = new Servant("lida", 12);

    public void slaveSaid(){
        servant.said();
    }

}

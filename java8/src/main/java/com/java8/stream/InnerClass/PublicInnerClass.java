package com.java8.stream.InnerClass;

public class PublicInnerClass {
    private int money;
    private String masterName;

    public PublicInnerClass(int money, String name) {
        this.money = money;
        this.masterName = name;
    }

    public class Servant {
        private String name;
        private int age;

        public void said () {
            System.out.println("I'am " + this.name);
            System.out.println("My Master is "+ masterName);
        }

        public void addMonney(int monney) {
            PublicInnerClass.this.money = PublicInnerClass.this.money + monney;
        }

        public void currentMoney() {
            System.out.println("My Master now is "+ PublicInnerClass.this.money);
        }

        public Servant(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    private Servant servant = new Servant("lida", 12);

    public Servant getServant() {
        return servant;
    }


}

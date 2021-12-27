package com.java8.stream.InnerClass;

public class PublicStaticInnerClass {
    private String masterName;
    private String address;

    public PublicStaticInnerClass(String masterName, String address) {
        this.masterName = masterName;
        this.address = address;
    }

    public static class Servant{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void said() {
            System.out.println("my name is " + name);
        }

    }

}

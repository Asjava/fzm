package com.java8.stream.InnerClass;

public class PrivateStaticInnerClass {
    private String masterName;
    private String address;

    public PrivateStaticInnerClass(String masterName, String address) {
        this.masterName = masterName;
        this.address = address;
    }

    private static class Servant{
        private static String name;

        public static String getName() {
            return name;
        }

        public static void setName(String name) {
            Servant.name = name;
        }

        public static void said() {
            System.out.println("my name is " + name);
        }
    }

    public void slaveSaid(){
        Servant.setName("lida");
        Servant.said();
    }

}

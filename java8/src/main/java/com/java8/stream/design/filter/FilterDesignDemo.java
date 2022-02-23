package com.java8.stream.design.filter;

public class FilterDesignDemo {
    public static void main(String[] args) {
        Target target = new Target();
        FilterManager filterManager = new FilterManager(target);
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new ParamFilter());
        filterManager.filterRequest("filter");
    }
}

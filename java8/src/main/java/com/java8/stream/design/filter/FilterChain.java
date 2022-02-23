package com.java8.stream.design.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filterList = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    public void  execute(String request) {
        for (Filter filter : filterList) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}

package com.fxs.fzm.common.utils;

import java.util.List;

public class Page<T> {
    private List<T> rows;
    private Long total;
    private Integer pageNum;
    private Integer pageSize;
    private Long totalPage;
    public Page(){}
    public Page(List<T> list, long totalRecords, int pageNum, int pageSize) {
        this.rows = list;
        this.total = totalRecords;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }
}

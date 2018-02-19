package com.base.wang.common;

import java.io.Serializable;

/**
 * 查参数类
 */
public class QueryParam implements Serializable {
    private Integer maxrows;
    private Integer firstrow;
    private Integer start;
    private Integer limit;
    /**
     * 查询条件
     */
    private String where;
    /***
     * 过滤
     */
    private String filter;
    /**
     * 排序
     */
    private String sort;

    public Integer getMaxrows() {
        return maxrows;
    }

    public void setMaxrows(Integer maxrows) {
        this.maxrows = maxrows;
    }

    public Integer getFirstrow() {
        return firstrow;
    }

    public void setFirstrow(Integer firstrow) {
        this.firstrow = firstrow;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

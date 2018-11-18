package com.example.playground.mybatis_generator.utils;

/**
 * @author gzliuzuoyan on 2017/3/10 0010.
 */
public class PageRequest {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer draw;

    public PageRequest(){
        this.pageIndex = 1;
        this.pageSize = 10;
    }

    public PageRequest(Integer pageIndex, Integer pageSize) {
        if(null == pageIndex || pageIndex <= 0) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }

        if(null == pageSize || pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }

    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return this.pageIndex * this.pageSize;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }
}
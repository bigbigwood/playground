package com.example.playground.mybatis_generator.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzuoyan on 2018/1/1.
 */
public class PageResult<T> {
    private long totalRecords;
    private int totalPages;
    private int pageSize;
    private int pageIndex;
    private List<T> PageData;

    public PageResult()
    {
        this.PageData = new ArrayList<>();
    }

    public PageResult(long totalRecords, int totalPages, int pageSize, int pageIndex, List<T> data)
    {
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.PageData = data;
    }

    public PageResult(long totalRecords, int pageSize, int pageIndex, List<T> data)
    {
        this.totalPages = (int)(totalRecords + pageSize - 1) / pageSize;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.PageData = data;
    }


    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getPageData() {
        return PageData;
    }

    public void setPageData(List<T> pageData) {
        PageData = pageData;
    }
}

package com.example.playground.mybatis_generator.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuzuoyan
 * @date 2018/3/24
 */
public class FilterPageRequest<T> extends PageRequest {
    private T condition;
    private Long startTime;
    private Long endTime;

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getSqlLikeKeyword(String keyword) { return StringUtils.isEmpty(keyword) ? "" : "%"+keyword+"%"; }
}

package com.example.playground.mybatis_generator.utils;


import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wood
 * @date 2018/1/7
 */
public final class HttpRequestUtils {

    /**
     * 判断请求是否为Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }


    /**
     * 从请求中获取分页参数对象： filterType,keyword,pageIndex,pageSize
     *
     * @param request
     * @return
     */
    public static FilterPageRequest getFilterKeywordPageRequest(HttpServletRequest request) {
        String pageIndex = request.getParameter("pageIndex");
        String pageSize = request.getParameter("pageSize");

        FilterPageRequest filterPageRequest = new FilterPageRequest();
        filterPageRequest.setPageIndex(StringUtils.isEmpty(pageIndex) ? 1 : Integer.parseInt(pageIndex));
        filterPageRequest.setPageSize(StringUtils.isEmpty(pageSize) ? 10 : Integer.parseInt(pageSize));

        Long startTime = request.getParameter("startTime") == null || StringUtils.isEmpty(request.getParameter("startTime")) ? null : Long.valueOf(request.getParameter("startTime"));
        Long endTime = request.getParameter("endTime") == null || StringUtils.isEmpty(request.getParameter("endTime")) ? null : Long.valueOf(request.getParameter("endTime"));
        filterPageRequest.setStartTime(startTime);
        filterPageRequest.setEndTime(endTime);

        return filterPageRequest;
    }
}

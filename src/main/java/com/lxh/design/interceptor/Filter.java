package com.lxh.design.interceptor;

/**
 * @Description 过滤器接口，用来执行过滤
 * @Author lxh
 * @Date 2021/2/13 21:09
 **/
public interface Filter {
    /**
     * 这个请求可以是任何对象，这个才是目标
     * @param request
     */
    void execute(String request);
}

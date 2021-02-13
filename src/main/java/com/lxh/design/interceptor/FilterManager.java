package com.lxh.design.interceptor;

/**
 * @Description 用来管理过滤器链
 * <p>
 *     使用FilterChain中的方法，增加（减少）过滤器，执行过滤
 * </p>
 * @Author lxh
 * @Date 2021/2/13 21:18
 **/
public class FilterManager {
    private FilterChain filterChain;

    /**
     * 初始化过滤器链，并设置好目标
     * @param target
     */
    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    /**
     * 向过滤器链中加过滤器
     * @param filter
     */
    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    /**
     * 通过 过滤器链 过滤请求 并执行目标业务逻辑
     * @param request
     */
    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}

package com.lxh.design.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 过滤器链
 * <p>
 *     只要是过滤器，都要有个过滤器链
 * </p>
 * @Author lxh
 * @Date 2021/2/13 21:14
 **/
public class FilterChain {
    private List<Filter> filterList = new ArrayList<>();
    private Target target;


    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    /**
     * 执行所有的过滤器，然后执行目标请求代码
     * @param request
     */
    public void execute(String request) {
        filterList.forEach(filter -> {
            filter.execute(request);
        });
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}

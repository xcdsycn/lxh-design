package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxh
 * @Date 2018/2/22
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target = target;
    }
}

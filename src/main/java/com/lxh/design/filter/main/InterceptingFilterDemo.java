package com.lxh.design.filter.main;
/**
 * Created by lxh on 2018/2/22.
 */

import com.lxh.design.filter.*;

/**
 * @author lxh
 * @Date 2018/2/22
 */
public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}

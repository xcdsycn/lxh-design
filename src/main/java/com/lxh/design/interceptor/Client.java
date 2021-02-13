package com.lxh.design.interceptor;

/**
 * @Description 客户端用来发送请求
 * @Author lxh
 * @Date 2021/2/13 21:21
 **/
public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }
}

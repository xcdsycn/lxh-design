package com.lxh.design.interceptor;

/**
 * @Description 调试过滤器
 * @Author lxh
 * @Date 2021/2/13 21:11
 **/
public class DebugFilter implements Filter{
    @Override
    public void execute(String request) {
        System.out.println("调试 request :  " + request);
    }
}

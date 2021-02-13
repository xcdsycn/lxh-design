package com.lxh.design.interceptor;

/**
 * @Description 授权过滤器
 * @Author lxh
 * @Date 2021/2/13 21:10
 **/
public class AuthenticationFilter implements Filter{
    @Override
    public void execute(String request) {
        System.out.println("AuthenticationFilter request :  " + request);
    }
}

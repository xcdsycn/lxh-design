package com.lxh.design.interceptor;

/**
 * @Description 请求真正执行的目标
 * @Author lxh
 * @Date 2021/2/13 21:13
 **/
public class Target {
    public void execute(String request) {
        System.out.println("执行请求：" + request);
    }
}

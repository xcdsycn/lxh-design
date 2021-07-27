package com.lxh.thread.future.timeout;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/7/26 09:08
 **/
@Slf4j
public class Task1 implements Action{

    @Override
    public void run() {
        try {
            System.out.println("task 1 开始执行,执行时间：10S");
            Thread.sleep(10000000);
            System.out.println("task 1 正常执行完成 10S");
        } catch (InterruptedException e) {
            log.error("<== task 1 执行异常，", e);
        }
    }
}

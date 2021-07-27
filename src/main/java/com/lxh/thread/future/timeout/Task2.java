package com.lxh.thread.future.timeout;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/7/26 09:08
 **/
@Slf4j
public class Task2 implements Action{

    @Override
    public void run() {
        try {
            System.out.println("task 2 开始执行，,执行时间：20S");

            Thread.sleep(20000000);
            System.out.println("task 2 正常执行完成 20S");
        } catch (InterruptedException e) {
            log.error("<== task 2 执行异常，", e);
        }
    }
}

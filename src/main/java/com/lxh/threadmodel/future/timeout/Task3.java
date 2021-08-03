package com.lxh.threadmodel.future.timeout;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/7/26 09:08
 **/
@Slf4j
public class Task3 implements Action{

    @Override
    public void run() {
        try {
            System.out.println("task 3 开始执行，执行时间：40S");
            Thread.sleep(40000);
            System.out.println("task 3 正常执行完成 40S");
        } catch (InterruptedException e) {
            log.error("<== task 3 执行异常，", e);
        }
    }
}

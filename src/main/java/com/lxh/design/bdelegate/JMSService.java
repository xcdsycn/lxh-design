package com.lxh.design.bdelegate;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/14 11:26
 **/
public class JMSService implements BusinessService{
    @Override
    public void doProcessing() {
        System.out.println("调用 JMS Service 处理任务");
    }
}

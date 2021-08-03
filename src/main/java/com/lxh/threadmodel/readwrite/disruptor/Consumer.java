package com.lxh.threadmodel.readwrite.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @Description 消费者
 * @Author lxh
 * @Date 2021/8/3 12:43
 **/
public class Consumer implements WorkHandler<PcData> {
    /**
     * disruptor框架的回调方法
     * @param pcData
     * @throws Exception
     */
    @Override
    public void onEvent(PcData pcData) throws Exception {
        System.out.println("消费者 Consumer 线程 -- " + Thread.currentThread().getId() + ":Event:取出值：" +
        pcData.getValue()  + "--");
    }
}

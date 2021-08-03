package com.lxh.threadmodel.readwrite.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Description 工厂类，在disruptor初始化时，构建所有缓冲区中的对象实例（disruptor会预先分配空间）
 * @Author lxh
 * @Date 2021/8/3 12:45
 **/
public class PcDataFactory implements EventFactory<PcData> {
    @Override
    public PcData newInstance() {
        return new PcData();
    }
}

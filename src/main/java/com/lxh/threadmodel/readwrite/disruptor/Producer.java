package com.lxh.threadmodel.readwrite.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @Description 生产者
 * @Author lxh
 * @Date 2021/8/3 12:47
 **/
public class Producer {
    private final RingBuffer<PcData> ringBuffer;

    public Producer(RingBuffer<PcData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer byteBuffer) {
        // grab the next sequence,得到下一个可用的序列号
        long sequence = ringBuffer.next();
        try {

            // get the entry in the disruptor for the sequence
            PcData event = ringBuffer.get(sequence);
            // fill with data，设置一个值
            event.setValue(byteBuffer.getLong(0));
        }finally {
            // 只有发布后的数据，才会被consumer真正看到
            ringBuffer.publish(sequence);
        }

    }
}

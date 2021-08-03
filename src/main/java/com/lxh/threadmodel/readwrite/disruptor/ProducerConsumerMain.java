package com.lxh.threadmodel.readwrite.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description 生产者、消费者主类，无锁的Disruptor缓存框架，生产、消费数据时使用CAS操作
 * @Author lxh
 * @Date 2021/8/3 12:55
 **/
public class ProducerConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        PcDataFactory pcDataFactory = new PcDataFactory();
        /**
         * 指定ringBuffer的大小必须为2的整数倍
         */
        int bufferSize = 1024;
        Disruptor<PcData> disruptor = new Disruptor<PcData>(pcDataFactory,
                bufferSize, executor, ProducerType.MULTI,
                new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer()
        );

        disruptor.start();
        // 在这一步将读写者通过RingBuffer关联起来，这样就生产者放进去，消费者取出来
        RingBuffer<PcData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long l=0; true; l++) {
            byteBuffer.putLong(0,l);
            producer.pushData(byteBuffer);
            Thread.sleep(100);
            System.out.println("生产者： add data " + l);
        }
    }

}

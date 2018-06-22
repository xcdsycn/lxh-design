package com.lxh.thread.delayedqueue;
/**
 * Created by lxh on 2018/4/8.
 */

import java.util.concurrent.DelayQueue;

/**
 * @author lxh
 * @Date 2018/4/8
 */
public class Consumer implements Runnable{
    // 延时队列
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println("消费消息：" + take.getId() + ":" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

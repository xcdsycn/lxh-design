package com.lxh.jdk.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description 信号量，允许多个线程同时进入临界区，本例，5个线程一批进入，可以看输出
 * @Author lxh
 * @Date 2021/8/2 14:45
 **/
public class SemaphoreDemo implements Runnable{
    final Semaphore semaphore = new Semaphore(5);
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i=0; i<20; i++) {
            // 可以放相同的，或者不同的线程去执行，本例是相同的
            service.submit(demo);
        }
        try {
            // 还有其他方式终止线程池，但是一般不需要终止，线程池一般都是单例的，随着应用程序结束而终止
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }
}

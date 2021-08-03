package com.lxh.threadmodel.basic.stampledlock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @Description stampedLock CPU陷阱
 * @Author lxh
 * @Date 2021/7/24 23:09
 **/
public class LockTrap {

    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                long readLong = lock.writeLock();
                // 如果这个时间够短，没有问题，如果时间太长，那么就会引起CPU会被疯狂占用，因为
                LockSupport.parkNanos(15000000000L);
                lock.unlockWrite(readLong);
            }
        }.start();

        Thread.sleep(100);

        for (int i=0; i<3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCpuReadThread());
            holdCpuThreads[i].start();
        }
        // 10S后中断,如果在10S内中断不受影响，如果超过10S
        Thread.sleep(10000);

        // 线程中断后会占用CPU
        for(int i=0; i<3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }

    private static class HoldCpuReadThread implements  Runnable {

        @Override
        public void run() {
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + "获得读锁");
            lock.unlockRead(lockr);
        }
    }
}

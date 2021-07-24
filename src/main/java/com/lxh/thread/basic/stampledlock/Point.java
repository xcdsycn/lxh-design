package com.lxh.thread.basic.stampledlock;

import java.util.concurrent.locks.StampedLock;

/**
 * @Description StampedLock的示例，这个是一个分段的支持乐观锁的读写锁
 * @Author lxh
 * @Date 2021/7/24 22:47
 **/
public class Point {

    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) {
        // 写锁排他
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 一定要写成这样，不然解锁不成功？？？
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!sl.validate(stamp)) {
            // 如果乐观锁没有得到，那么升级为悲观锁
            stamp = sl.readLock();

            try {
                currentX = x;
                currentY = y;
            } finally {
                // 一定要写成这样，不然解锁不成功？？？
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}

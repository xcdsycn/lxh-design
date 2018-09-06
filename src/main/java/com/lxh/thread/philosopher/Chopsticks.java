package com.lxh.thread.philosopher;
/**
 * Created by lxh on 2018/6/22.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 两种死锁避免算法：
 *
 * *进程启动拒绝：如果一个进程的请求会导致死锁，则不启动该进程。
 *
 * *资源分配拒绝：如果一个进程增加的资源请求会导致死锁，则不允许此分配(银行家算法)。
 * @author lxh
 * @Date 2018/6/22
 */
public class Chopsticks {
    public static List<Boolean> chops = new ArrayList<Boolean>();
    /** 工作向量work：表示系统可提供给进程继续运行的所需的各类资源的数目，执行安全算法开始时 work=available。**/
    static {
        //为了方便计算，第一个不会参与计算
        chops.add(false);
        chops.add(false);
        chops.add(false);
        chops.add(false);
        chops.add(false);
    }

    /**
     * 如果能同时获取两个资源，就获取，否则释放资源
     */
    public synchronized void getChop() {
        String currentName = Thread.currentThread().getName();
        int index = Integer.parseInt(currentName);
        while (chops.get(index) || chops.get((index + 1)%5)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chops.set(index, true);
        chops.set((index + 1)%5 ,true);
    }
    public synchronized void freeChop() {
        String currentName = Thread.currentThread().getName();
        int index = Integer.parseInt(currentName);
        chops.set(index, false);
        chops.set((index + 1)%5 ,false);
        notifyAll();
    }
}

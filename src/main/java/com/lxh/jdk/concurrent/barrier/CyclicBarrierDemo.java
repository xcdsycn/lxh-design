package com.lxh.jdk.concurrent.barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description 循环栅栏，可以重复计数
 * @Author lxh
 * @Date 2021/8/2 15:25
 **/
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable{

        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
            this.soldier = soldier;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // 等 soldier到齐
            try {
                cyclicBarrier.await();
                doWork();
                // 等所有soldier工作完成
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }
    }

    /**
     * 回调方法，用于在每个barrier到期以后的回调
     */
    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if(flag) {
                System.out.println("司令：【士兵" + N + "个，任务完成！】");
            }else{
                System.out.println("司令：【士兵" + N + "个，集合完毕！】");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final  int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        // 设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for(int i=0; i<N; i++) {
            System.out.println("士兵"+ i + "报到！");
            allSoldier[i] = new Thread(new Soldier("士兵"+ i,cyclicBarrier));
            allSoldier[i].start();
            if (i == 5) {
                allSoldier[0].interrupt();
            }
        }
    }
}

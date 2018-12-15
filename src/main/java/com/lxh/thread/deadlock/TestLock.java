package com.lxh.thread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLock {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private String name;

    /**
     * 同步方法1
     * @return
     */
    public synchronized String getName() {
        return name;
    }

    /**
     * 同步方法2
     * @param t
     */
    public synchronized void print(TestLock t) {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(name + " end sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + " synchroinzed");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestLock(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {

        final TestLock t1 = new TestLock("t1");
        final TestLock t2 = new TestLock("t2");

        executor.execute(new Runnable() {
            @Override
            public void run() {
                t1.print(t2);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                t2.print(t1);
            }
        });

    }
}

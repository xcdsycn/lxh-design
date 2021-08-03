package com.lxh.jdk.concurrent.threadpool;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/8/2 19:46
 **/
public class DivTask implements Runnable{
    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }
}

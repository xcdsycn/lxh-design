package com.lxh.threadmodel.future.noitfy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description 主线程完成了，通知子线程
 * @Author lxh
 * @Date 2021/7/24 17:28
 **/
@Slf4j
public class AskTask implements Runnable{
    CompletableFuture<Integer> re = null;

    public AskTask(CompletableFuture<Integer> re) {
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            // 子线程接收外部同步的方式来工作
            // 这个意思是，completableFuture可以作为与外界同步的一个机制，这是很重要的
            System.out.println("==> 子线程开始等待");
            log.info("==> future.get()");
            myRe = re.get() * re.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskTask(future)).start();
        // long time mock
        // 这里的意思是，主线程可以去做其他的事，子线程也可以做其他的事，如果需要主线程的结果，那么就可以在主线程具备了
        // 再告诉子线程，需要的结果，那么子线程就可以继续执行了
        // 否则，子线程将被hang住，等待 future.complete的调用
        try {
            System.out.println("==> 延时 1S 输出结果");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("==> 等待完成，输出计算结果：");
        // 告知完成结果
        future.complete(60);
    }
}

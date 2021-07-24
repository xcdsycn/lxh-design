package com.lxh.thread.future.exception;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description 异常处理
 * @Author lxh
 * @Date 2021/7/24 22:25
 **/
public class Exception {

    public static Integer calc(Integer para)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para/0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu = CompletableFuture
                .supplyAsync(()-> calc(50))
                .exceptionally( ex->{
                    // 线程内执行异常的时候，可以统一处理异常，这样可以返回正确的结果
                    // 如果线程内都正确的捕获了异常，那么就不需要这样去做了
                    System.out.println("线程执行异常："  + ex.getMessage());
                    System.out.println("当异常的时候返回 0 值");
                    return 0;
                })
                .thenApply(i-> Integer.toString(i))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        try {
            fu.get(20, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println("超时异常");
            // 这时要将线程取消
            fu.cancel(true);
            e.printStackTrace();
        }
    }
}

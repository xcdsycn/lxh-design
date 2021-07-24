package com.lxh.thread.future.stream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description 流式调用，组合调用
 * @Author lxh
 * @Date 2021/7/24 22:04
 **/
public class FutureStreamCalled {
    public static Integer calc(Integer para) {
        return para/2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(()->calc(50))
                .thenCompose(i-> CompletableFuture.supplyAsync(()->calc(i)))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future.get();
    }
}

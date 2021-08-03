package com.lxh.threadmodel.future.stream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description 组合
 * @Author lxh
 * @Date 2021/7/24 22:42
 **/
public class Combine {
    public static Integer calc(Integer para) {
        return para/2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> intFuture = CompletableFuture
                .supplyAsync(() -> calc(50));

        CompletableFuture<Integer> intFuture2 = CompletableFuture
                .supplyAsync(() -> calc(25));

        CompletableFuture<Void> future = intFuture
                .thenCombine(intFuture2, (i,j) -> i+j)
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future.get();

    }
}

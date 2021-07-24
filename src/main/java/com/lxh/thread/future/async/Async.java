package com.lxh.thread.future.async;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * @Description 异步执行任务
 * @Author lxh
 * @Date 2021/7/24 21:39
 **/
public class Async {
    @SneakyThrows
    public static Integer calc(Integer para) {
        // mock long time task
        Thread.sleep(1000);
        return para * para;
    }

    @SneakyThrows
    public static void main(String[] args) {
        final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> calc(50)
        ).exceptionally(e -> {System.out.println(e.getMessage());
            return 0;
        });

        System.out.println("==> 计算结果：" + future.get());
        System.out.println("end ....");
    }
}

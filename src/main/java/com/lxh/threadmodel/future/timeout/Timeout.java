package com.lxh.threadmodel.future.timeout;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description CompletableFuture 中 cancel不会真正中断线程的执行，只会让线线的同步方法快速返回
 * @Author lxh
 * @Date 2021/7/26 09:08
 **/
@Slf4j
public class Timeout {
    public static void main(String[] args) {
        List<Action> actions = new ArrayList<>();
        // 10S
        actions.add(new Task1());
        // 20S
        actions.add(new Task2());
        // 40
        actions.add(new Task3());
        List<Integer> timeouts = new ArrayList<>();
        timeouts.add(5);
        timeouts.add(10);
        timeouts.add(15);
//        Executor executor = Executors.newFixedThreadPool(2);
        Executor executor = new ThreadPoolExecutor(2,2,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("---> " + t.getName() + " id:" + t.getId());
                System.out.println("准备执行：" + r.getClass().getSimpleName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成：" + r.getClass().getSimpleName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        int i = 0;
        long startTotal = System.currentTimeMillis();
        for (Action action : actions) {
            long start = System.currentTimeMillis();
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                action.run();
            }, executor);
            try {
                int timeout = timeouts.get(i++);
                log.info("==> {} 的超时时间为： {}", action.getClass().getSimpleName(), timeout);
                future.get(timeout, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                log.error("===> timeout {}", action.getClass().getSimpleName(), e);
                future.completeExceptionally(new Exception(action.getClass().getSimpleName() + " 超时异常"));
                // 并不能真正中断线程的执行，设置的超时，会让线程池中的线程快速返回，但是线程的执行还是会快速执行完成了
                try {
                    future.cancel(true);
                }catch (Exception ex) {
                    log.error("<=== 取消异常，", ex);
                }
            } finally {
                long end = System.currentTimeMillis();
                log.info("==> {} 花费时间：{}", action.getClass().getSimpleName(), end - start);
            }
        }
        long endTotal = System.currentTimeMillis();
        System.out.println("==> 总时间： " + (endTotal - startTotal));
    }
}

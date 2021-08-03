package com.lxh.jdk.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @Description 打印任务提交信息
 * @Author lxh
 * @Date 2021/8/2 19:32
 **/
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command,clientTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("客户端异常栈信息：");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        // 在错误堆栈中可以看到错误信息
        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(new DivTask(100, i));
        }
    }
}

package com.lxh.thread.basic.cyclicbarrier;

import java.util.concurrent.*;

/**
 * 这里要注意线程池数量的设置，
 * 如果不超过 cyclicBarrier的数量，
 * 将导致线程无限等待 对于countDownLatch也是一样的效果
 *
 * @author lxh
 */
public class CyclicBarrierExample2 {

	// 请求的数量
	private static final int THREAD_COUNT = 550;

	// 需要同步的线程数量
	private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
		System.out.println("------当线程数达到之后，优先执行------");
	});

	public static void main(String[] args) throws InterruptedException {
		// 创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			threadPool.execute(() -> {
				test(threadNum);
			});
		}
		threadPool.shutdown();
	}

	public static void test(int threadnum) {
		System.out.println("threadnum:" + threadnum + "is ready");
		try {
			// 当到达指定时间后，中断等待，会抛出InterruptedException 异常
			cyclicBarrier.await(5000, TimeUnit.MILLISECONDS);
			// 这个就会无限等下去，直到有指定数量的线程运行为止
			// cyclicBarrier.wait();
		}
		catch (Exception e) {
			System.out.println("-----CyclicBarrierException------");
		}
		System.out.println("threadnum:" + threadnum + "is finish");
	}

}

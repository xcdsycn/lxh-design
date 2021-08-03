package com.lxh.threadmodel.basic.countdownlatch;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程池中，超过队列中的线程到来的时候，就直接拒绝服务，产生 threadPoolRejectException 而且，如果队列满了，但是线程池中的最大线程数可以满足并发需求，
 * 就不会产生异常 corePoolSize决定了执行任务的线程数 缓冲队列的长度，是系统的可以容忍的最大吞量要求
 *
 * @author lxh
 */
public class CountDownLatchExample1 {

	/**
	 * 请求的数量
	 */
	private static final int THREAD_COUNT = 550;

	public static void main(String[] args) throws InterruptedException {
		// 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("lxh-thread-%d").build();

		ExecutorService threadPool = new ThreadPoolExecutor(50, 50, 500, TimeUnit.MILLISECONDS,
				new LinkedBlockingDeque<>(1000), threadFactory);

		final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
		for (int i = 0; i < THREAD_COUNT; i++) {
			final int threadnum = i;
			threadPool.execute(() -> {
				try {
					test(threadnum);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					countDownLatch.countDown();
				}

			});
		}
		countDownLatch.await();
		threadPool.shutdown();
		System.out.println("finish");
	}

	public static void test(int threadnum) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("threadnum:" + threadnum);
		Thread.sleep(1000);
	}

}

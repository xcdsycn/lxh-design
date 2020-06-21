package com.lxh.thread.readwrite;

/**
 * Created by lxh on 2018/6/22.
 */

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个信息号量，一个读、一个写就可以完成读写者问题
 *
 * @author lxh
 * @Date 2018/6/22
 */
public class SimpleExample {

	private static SimpleExample threadSync;

	private static Thread t1, t2, t3, t4, t5;

	private static final Random rand = new Random();

	private static Semaphore sm = new Semaphore(2);

	// 信号量 允许2个线程 true表示先进先出

	private static Semaphore wsm = new Semaphore(1);

	// 信号量 允许1个线程

	String text = "Beginning of the Book";

	// 代表书本

	AtomicInteger readerCount = new AtomicInteger(0);

	// 记录当前读者数量，只为了单纯输出日志用

	AtomicInteger writerCount = new AtomicInteger(0);

	// 记录当前写者数量， 只为了单纯输出日志用

	/**
	 * 随机休眠一定时间
	 */
	private void busy() {
		try {
			Thread.sleep(rand.nextInt(1000) + 1000);
		}
		catch (InterruptedException e) {
		}
	}

	/**
	 * 写函数
	 */
	void write(String sentence) {
		System.out.println(Thread.currentThread().getName() + " started to WRITE");
		text += "\n" + sentence;
		System.out.println(text);
		System.out.println("End of Book\n");
		System.out.println(Thread.currentThread().getName() + " finished WRITING");
	}

	/**
	 * read
	 */
	void read() {

		System.out.println("\n" + Thread.currentThread().getName() + " started to READ");
		// System.out.println(text);
		// System.out.println("End of Book\n");

	}

	/**
	 * writer
	 */
	private class Writer implements Runnable {

		SimpleExample ts;

		Writer(SimpleExample ts) {
			super();
			this.ts = ts;

		}

		@Override
		public void run() {
			while (true) {
				if (readerCount.get() == 0) {
					// 当没有读者时才 可以写
					try {
						// System.out.println("write---readerCount= "+readerCount.get());
						// System.out.println("write---writerCount= "+writerCount.get());
						wsm.acquire(); // 信号量获取允许
						writerCount.getAndIncrement();
					}
					catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					String new_sentence = "\tnew line in Book";
					busy();
					ts.write(new_sentence);
					wsm.release(); // 信号量释放
					writerCount.getAndDecrement();

					busy();

				}
			} // of while
		}

	}

	// 读者
	private class Reader implements Runnable {

		SimpleExample ts;

		Reader(SimpleExample ts) {
			super();
			this.ts = ts;

		}

		@Override
		public void run() {
			while (true) {
				if (writerCount.get() == 0) {
					// 没有写者时 才可以读
					try {
						// System.out.println("Read---readerCount= "+readerCount.get());
						// System.out.println("Read---writerCount= "+writerCount.get());
						sm.acquire(); // 读者获取允许
						readerCount.getAndIncrement();
					}
					catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					// System.out.print(t);

					ts.read();
					busy();
					System.out.println(Thread.currentThread().getName() + " end of read");
					sm.release(); // 释放允许
					readerCount.getAndDecrement();
					busy();
				}
			} // of while
		}

	}

	/**
	 * 创建两个读者 一个写者
	 */
	public void startThreads() {
		SimpleExample ts = new SimpleExample();
		t1 = new Thread(new Writer(ts), "Writer # 1");
		t2 = new Thread(new Writer(ts), "Writer # 2");
		t3 = new Thread(new Reader(ts), "Reader # 1");
		t4 = new Thread(new Reader(ts), "Reader # 2");
		// t5 = new Thread(new Reader(ts), "Reader # 3");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// t5.start();
	}

	public static void main(String[] args) {
		threadSync = new SimpleExample();
		System.out.println("Lets begin...\n");
		threadSync.startThreads();
	}

}

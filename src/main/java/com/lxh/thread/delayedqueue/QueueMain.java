package com.lxh.thread.delayedqueue;
/**
 * Created by lxh on 2018/4/8.
 */

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 队列里的元素过了延期时间，才会被取出，不然就不返回
 *
 * DelayQueue是一个BlockingQueue，其特化的参数是Delayed。（不了解BlockingQueue的同学，先去了解BlockingQueue再看本文）
 * Delayed扩展了Comparable接口，比较的基准为延时的时间值，Delayed接口的实现类getDelay的返回值应为固定值（final）。DelayQueue内部是使用PriorityQueue实现的。
 * DelayQueue = BlockingQueue + PriorityQueue + Delayed
 *
 * @author lxh
 * @Date 2018/4/8
 */
public class QueueMain {

	private static int num = 0;

	public static void main(String[] args) {
		DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();

		// 生产者
		producer(delayQueue);

		// 消费者
		consumer(delayQueue);

		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("======================================");
				// TimeUnit.HOURS.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 每100毫秒创建一个对象，放入延迟队列，延迟时间1毫秒
	 * @param delayQueue
	 */
	private static void producer(final DelayQueue<DelayedElement> delayQueue) {
		// 随机数的种子不可预测
		// SecureRandom类收集了一些随机事件，比如鼠标点击，键盘点击等等，SecureRandom 使用这些随机事件作为种子
		final SecureRandom secureRandom = new SecureRandom();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Integer seconds = secureRandom.nextInt(1000);
						System.out.println("producer seconds:" + seconds);
						TimeUnit.MILLISECONDS.sleep(seconds);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}

					DelayedElement element = new DelayedElement(100, "test" + num);
					num++;
					delayQueue.put(element);

				}
			}
		}).start();

		/**
		 * 每秒打印延迟队列中的对象个数
		 */
		new Thread(new Runnable() {
			public void run() {

				while (true) {
					System.out.println("delayQueue size:" + delayQueue.size());
					try {
						TimeUnit.MILLISECONDS.sleep(1000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	/**
	 * 消费者，从延迟队列中获得数据,进行处理
	 * @param delayQueue
	 */
	private static void consumer(final DelayQueue<DelayedElement> delayQueue) {
		final List<DelayedElement> list = new ArrayList<DelayedElement>();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					DelayedElement element = delayQueue.poll();
					if (null == element) {
						// System.out.println("==> 取数据未取到");
						try {
							list.clear();
							Thread.sleep(100);
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else {
						list.add(element);
						System.out.println("==> element:" + element);
						System.out.println("==> list size:" + list.size());
					}
				}
			}
		}).start();
	}

}

class DelayedElement implements Delayed {

	private final long delay;

	// 延迟时间
	private final long expire;

	// 到期时间
	private final String msg;

	// 数据
	private final long now;

	// 创建时间

	public DelayedElement(long delay, String msg) {
		this.delay = delay;
		this.msg = msg;
		expire = System.currentTimeMillis() + delay;
		// 到期时间 = 当前时间+延迟时间
		now = System.currentTimeMillis();
	}

	/**
	 * 需要实现的接口，获得延迟时间 用过期时间-当前时间
	 * @param unit
	 * @return
	 */
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	/**
	 * 用于延迟队列内部比较排序 当前时间的延迟时间 - 比较对象的延迟时间
	 * @param o
	 * @return
	 */
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DelayedElement{");
		sb.append("delay=").append(delay);
		sb.append(", expire=").append(expire);
		sb.append(", msg='").append(msg).append('\'');
		sb.append(", now=").append(now);
		sb.append('}');
		return sb.toString();
	}

}

package com.lxh.thread.philosopher;
/**
 * Created by lxh on 2018/6/22.
 */

/**
 * @author lxh
 * @Date 2018/6/22
 */
public class PhilosopherThread extends Thread {

	private String name;

	// 线程名称，给哲学家编序号用

	private Chopsticks chopsticks;

	public PhilosopherThread(String name, Chopsticks chopsticks) {
		super(name);
		// this.name = name;
		this.chopsticks = chopsticks;
	}

	@Override
	public void run() {
		while (true) {
			chopsticks.getChop();
			System.out.println(Chopsticks.chops);
			this.eat();
			chopsticks.freeChop();
		}
	}

	public void eat() {
		try {
			System.out.println(Thread.currentThread().getName() + " ---- eating");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " ---- end  eating");

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

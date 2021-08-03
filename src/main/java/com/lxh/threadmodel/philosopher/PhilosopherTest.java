package com.lxh.threadmodel.philosopher;
/**
 * Created by lxh on 2018/6/22.
 */

/**
 * @author lxh
 * @Date 2018/6/22
 */
public class PhilosopherTest {

	public static void main(String[] args) {
		Chopsticks chopsticks = new Chopsticks();
		PhilosopherThread philosopherThread1 = new PhilosopherThread("0", chopsticks);
		PhilosopherThread philosopherThread2 = new PhilosopherThread("1", chopsticks);
		PhilosopherThread philosopherThread3 = new PhilosopherThread("2", chopsticks);
		PhilosopherThread philosopherThread4 = new PhilosopherThread("3", chopsticks);
		PhilosopherThread philosopherThread5 = new PhilosopherThread("4", chopsticks);

		philosopherThread1.start();
		philosopherThread2.start();
		philosopherThread3.start();
		philosopherThread4.start();
		philosopherThread5.start();
	}

}

package com.lxh.thread.deadlock.lock;

/**
 * 两个死锁的例子，都是发生在多个资源的使用的情况下 如果只有一个临界资源，是无法发生死锁的
 * 多个临界资源在加锁顺序不同的时候就会发生死锁，如果保证加锁顺序一致，刚不会发生死锁，前提是加锁之前都有加锁成功的检测 这其实就是一次性的申请资源成功，try lock
 * 如果成功，其它线程的 try lock 就不会成功
 */
public class LockTest {

	public static String obj1 = "obj1";

	public static String obj2 = "obj2";

	public static void main(String[] args) {
		LockA la = new LockA();
		new Thread(la).start();
		LockB lb = new LockB();
		new Thread(lb).start();
	}

}

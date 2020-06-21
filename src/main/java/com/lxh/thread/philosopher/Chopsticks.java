package com.lxh.thread.philosopher;

/**
 * Created by lxh on 2018/6/22.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxh
 * @Date 2018/6/22
 */
public class Chopsticks {

	public static List<Boolean> chops = new ArrayList<Boolean>();
	static {
		chops.add(false);
		// 为了方便计算，第一个不会参与计算
		chops.add(false);
		chops.add(false);
		chops.add(false);
		chops.add(false);
	}

	public synchronized void getChop() {
		String currentName = Thread.currentThread().getName();
		int index = Integer.parseInt(currentName);
		while (chops.get(index) || chops.get((index + 1) % 5)) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		chops.set(index, true);
		chops.set((index + 1) % 5, true);
	}

	public synchronized void freeChop() {
		String currentName = Thread.currentThread().getName();
		int index = Integer.parseInt(currentName);
		chops.set(index, false);
		chops.set((index + 1) % 5, false);
		notifyAll();
	}

}

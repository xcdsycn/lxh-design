package com.lxh.guava;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

public class DeadEventSubscriber {

	@Subscribe
	public void deal(DeadEvent e) {
		System.out.println("===> this is dead event:" + e.getEvent());
	}

}

package com.lxh.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class IntegerSubscriber {

	@Subscribe
	public void recordCoustomerChange(Integer e) {
		System.out.println("======> Integer: " + e);
	}

}

package com.lxh.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class StringSubscriber {

	@Subscribe
	public void recordCustomerChange(String e) {
		System.out.println("======> String: " + e);
	}

}

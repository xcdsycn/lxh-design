package com.lxh.guava;

import com.google.common.eventbus.Subscribe;

import javax.swing.event.ChangeEvent;


public class StringSubscriber {
    @Subscribe
    public void recordCoustomerChange(String e) {
        System.out.println("======> String: " + e);
    }
}

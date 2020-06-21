package com.lxh.guava;

import com.google.common.eventbus.EventBus;

public class EventBusMain {

    private static EventBus eventBus = new EventBus();

    public static void main(String[] args) {
        IntegerSubscriber integerSubscriber = new IntegerSubscriber();
        StringSubscriber stringSubscriber = new StringSubscriber();

        eventBus.register(integerSubscriber);
        eventBus.register(stringSubscriber);

        eventBus.post("hello");
        eventBus.post(1232);

        eventBus.post(new IntegerSubscriber());

        eventBus.unregister(integerSubscriber);
        eventBus.post("hello");
        eventBus.post(1232);

        eventBus.post(12334L);

    }
}

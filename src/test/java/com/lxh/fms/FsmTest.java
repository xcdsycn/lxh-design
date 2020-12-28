package com.lxh.fms;

import com.lxh.ApplicationTests;
import com.lxh.constants.Events;
import com.lxh.constants.Events1;
import com.lxh.constants.States;
import com.lxh.constants.States1;
import com.lxh.fsm.E1StateMachineBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

public class FsmTest extends ApplicationTests {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Autowired
	private E1StateMachineBuilder machineBuilder;

	@Autowired
	private BeanFactory beanFactory;

	@Test
	public void testE1() {
		Message messageE1 = MessageBuilder.withPayload(Events.E1).setHeader("params", "E1 message").build();
		stateMachine.sendEvent(messageE1);
	}

	@Test
	public void testE2() {
		Message messageE2 = MessageBuilder.withPayload(Events.E2).setHeader("params", "E2 message").build();
		stateMachine.sendEvent(messageE2);
	}

	@Test
	public void test1() throws Exception {
		StateMachine<States1, Events1> stateMachine1 = machineBuilder.buildE1(beanFactory);
		Message messageE1 = MessageBuilder.withPayload(Events.E1).setHeader("params1", "E1 message").build();
		stateMachine1.sendEvent(messageE1);
	}

}

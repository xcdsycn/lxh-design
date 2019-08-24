package com.lxh.fsm;

import com.lxh.constants.Events1;
import com.lxh.constants.States1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
public class E1StateMachineBuilder {

	private final static String MACHINEID = "orderMachine";

	public StateMachine<States1, Events1> buildE1(BeanFactory beanFactory) throws Exception {
		StateMachineBuilder.Builder<States1, Events1> builder = StateMachineBuilder.builder();

		builder.configureConfiguration().withConfiguration().autoStartup(true).listener(listenerSheet())
				.machineId(MACHINEID);

		builder.configureStates().withStates().initial(States1.SI).states(EnumSet.allOf(States1.class));

		builder.configureTransitions().withExternal().source(States1.SI).target(States1.S1).event(Events1.E1)
				.action(new E1Action1()).and().withExternal().source(States1.S1).target(States1.S2).event(Events1.E2);
		return builder.build();
	}

	@Bean
	public StateMachineListener<States1, Events1> listenerSheet() {
		return new StateMachineListenerAdapter<States1, Events1>() {
			@Override
			public void stateChanged(State<States1, Events1> from, State<States1, Events1> to) {
				System.out.println("State change to " + to.getId());
			}
		};

	}

}

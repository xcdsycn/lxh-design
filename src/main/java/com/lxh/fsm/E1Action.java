package com.lxh.fsm;

import com.lxh.constants.Events;
import com.lxh.constants.States;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Component
public class E1Action implements Action<States, Events> {

	@Override
	public void execute(StateContext<States, Events> stateContext) {
		System.out.println("into ComplexFormChoiceAction");
		String params = stateContext.getMessage().getHeaders().get("params1", String.class);
		System.out.println(" ===> " + params);
		System.out.println("===> " + stateContext.getStateMachine().getState());
	}

}

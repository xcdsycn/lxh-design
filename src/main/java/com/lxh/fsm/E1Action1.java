package com.lxh.fsm;

import com.lxh.constants.Events1;
import com.lxh.constants.States1;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Component
public class E1Action1 implements Action<States1, Events1> {

	@Override
	public void execute(StateContext<States1, Events1> stateContext) {
		System.out.println("into ComplexFormChoiceAction");
		String params = stateContext.getMessage().getHeaders().get("params", String.class);
		System.out.println(" ===> " + params);
		System.out.println("===> " + stateContext.getStateMachine().getState());
	}

}

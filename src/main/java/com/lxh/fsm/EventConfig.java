package com.lxh.fsm;

import com.lxh.constants.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine(id = "sheetMachine")
@Slf4j
public class EventConfig {

	@OnTransition(target = "SI")
	public void createI() {
		log.info("SI initial");
	}

	@OnTransition(source = "SI", target = "S1")
	public void fromI21(Message<Events> message) {
		log.info("SI -> S1, message:{}", message.getHeaders().get("params"));
	}

	@OnTransition(source = "S1", target = "S2")
	public void from1to2(Message<Events> message) {
		log.info("S1 -> S2,message:{}", message.getHeaders().get("params"));
	}

}

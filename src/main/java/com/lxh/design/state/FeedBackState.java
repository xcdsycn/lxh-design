package com.lxh.design.state;

/**
 * @author lxh
 */
public class FeedBackState extends AbstractState {

	@Override
	public String getCurrentState() {
		return StateEnum.FEED_BACKED.getValue();
	}

}

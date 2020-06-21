package com.lxh.spi;

import com.lxh.spi.intf.View;

/**
 * @author lxh
 */
public class TextView implements View {

	@Override
	public void view() {
		System.out.println("Text view.");
	}

}

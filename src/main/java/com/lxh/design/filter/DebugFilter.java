package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
 * @author lxh
 * @Date 2018/2/22
 */
public class DebugFilter implements Filter {

	public void execute(String request) {
		System.out.println("Debug Filter ==> request log: " + request);
	}

}

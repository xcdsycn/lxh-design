package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
 * @author lxh
 * @Date 2018/2/22
 */
public class AuthenticationFilter implements Filter {

	public void execute(String request) {
		System.out.println("Authenticating request: " + request);
	}

}

package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
 * @author lxh
 * @Date 2018/2/22
 */
public class Target {

	public void execute(String request) {
		System.out.println("### 到达最终目标 target : Executing request: " + request);
	}

}

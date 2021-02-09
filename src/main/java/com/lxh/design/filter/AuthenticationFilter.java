package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
* 这个Filter是具体的实现，filter可以不只做一件事，所以可以有很多的方法，过滤的对象也可以是抽象的
*
* filter的目标是输入参数，原则是不能对参数做改变：那就是事件机制；如果对参数做了改变，就有点像流式计算
*
 * @author lxh
 * @Date 2018/2/22
 */
public class AuthenticationFilter implements Filter {

	public void execute(String request) {
		System.out.println("==> Authenticating request: " + request);
	}

}

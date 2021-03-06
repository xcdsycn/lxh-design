package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
* 基于filterManager作为媒介，向FilterChain中发送请求
 * @author lxh
 * @Date 2018/2/22
 */
public class Client {

	FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}

}

package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
* 用来执行FilterChain的生命周期管理，使用其他的代理 工具 执行chain中的 filter
 * @author lxh
 * @Date 2018/2/22
 */
public class FilterManager {

	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}

}

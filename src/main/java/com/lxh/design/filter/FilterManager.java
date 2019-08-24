package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
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

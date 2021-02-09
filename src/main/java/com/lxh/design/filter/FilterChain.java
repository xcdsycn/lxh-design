package com.lxh.design.filter;

/**
 * Created by lxh on 2018/2/22.
 */

import java.util.ArrayList;
import java.util.List;

/**
* 所有的Filter都要放到一个列表里，用来循环执行，在列表的最后，是目标，<br>
* 其实，目标可以放到列表的最后来执行，可以不用这种形式就可以了
 * @author lxh
 * @Date 2018/2/22
 */
public class FilterChain {

	private List<Filter> filters = new ArrayList<Filter>();

	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (Filter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}

}

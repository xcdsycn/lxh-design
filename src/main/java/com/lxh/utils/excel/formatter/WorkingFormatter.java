package com.lxh.utils.excel.formatter;

import cn.chenhuanming.octopus.formatter.AbstractFormatter;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WorkingFormatter extends AbstractFormatter<Boolean> {

	public WorkingFormatter() {
	}

	@Override
	public Boolean parseImpl(String str) throws Exception {
		return "Working".equals(str);
	}

	@Override
	public String format(Boolean aBoolean) {
		return aBoolean ? "Working" : "Leaved";
	}

}

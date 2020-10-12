package com.lxh.guava.character;

import com.google.common.base.CaseFormat;

public class CharacterUtil {

	public static void main(String[] args) {
		String str = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
		System.out.println(str);

	}

}

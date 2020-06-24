package com.lxh.guava.boomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import lombok.Data;

import java.util.List;

/**
 * 说明 Bloom Filter 的用法
 */
@Data
public class Person {

	final int id;

	final String firstName;

	final String lastName;

	final int birthYear;

	Funnel<Person> personFunnel = new Funnel<Person>() {
		@Override
		public void funnel(Person person, PrimitiveSink into) {
			into.putInt(person.id).putString(person.firstName, Charsets.UTF_8)
					.putString(person.lastName, Charsets.UTF_8).putInt(birthYear);
		}
	};

	/**
	 * 测试是否存在
	 * @param friendList
	 * @param dude
	 */
	public void testExist(List<Person> friendList, Person dude) {
		// 创建 bloom 过滤器
		BloomFilter<Person> friends = BloomFilter.create(personFunnel, 500, 0.01);
		for (Person friend : friendList) {
			friends.put(friend);
		}
		// 很久以后
		if (friends.mightContain(dude)) {
			// dude不是朋友还运行到这里的概率为1%
			// 在这儿，我们可以在做进一步精确检查的同时触发一些异步加载
			// 因为有 1% 的概率是不准的，所以需要再次检测，但是因为99%就都准，所以还是提高了性能
		}
	}

}

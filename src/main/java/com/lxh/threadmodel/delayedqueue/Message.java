package com.lxh.threadmodel.delayedqueue;

/**
 * Created by lxh on 2018/4/8.
 */

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author lxh
 * @Date 2018/4/8
 */
public class Message implements Delayed {

	private int id;

	private String body; // 消息内容

	private long excuteTime;// 执行时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(long excuteTime) {
		this.excuteTime = excuteTime;
	}

	public Message(int id, String body, long delayTime) {
		this.id = id;
		this.body = body;
		this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
	}

	public int compareTo(Delayed delayed) {
		Message msg = (Message) delayed;
		return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
				: (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
	}

	public long getDelay(TimeUnit unit) {
		return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

}

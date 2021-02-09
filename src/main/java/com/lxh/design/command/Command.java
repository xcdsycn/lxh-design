package com.lxh.design.command;

/***
 * @Author lxh
 * @Description 作为命令接口 其实现做实际命令的处理<Br>
 * 命令模式是数据驱动设计模式，属于行为模式类别。 <br>
 * 请求作为命令包装在一个对象下，并传递给调用器对象。 <br>
 * 调用者对象查找可以处理此命令的适当对象，并将命令传递到执行命令的相应对象。
 * @Date 2021/2/8 15:43
 **/
public interface Command {

	/**
	 * 执行命令
	 */
	void execute();

}

package com.lxh.design.filter;
/**
 * Created by lxh on 2018/2/22.
 */

/**
 * 过滤器（条件）
 *
 * 使开发人员可以使用不同的条件过滤一组对象，并通过逻辑操作以解耦方式将其链接。 <br>
 * 这种类型的设计模式属于结构模式，因为该模式组合多个标准以获得单个标准。
 *
 * @author lxh
 * @Date 2018/2/22
 */
public interface Filter {

	public void execute(String request);

}

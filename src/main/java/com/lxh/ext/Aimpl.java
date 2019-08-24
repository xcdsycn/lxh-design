package com.lxh.ext;
/**
 * Created by lxh on 2018/5/9.
 */

/**
 * @author lxh
 * @Date 2018/5/9
 */
public class Aimpl extends AbstractA implements InterfA {

	public void test() {
		System.out.println("==> test");
	}

	public static void main(String[] args) {
		Aimpl aimpl = new Aimpl();
		aimpl.test();
	}

}

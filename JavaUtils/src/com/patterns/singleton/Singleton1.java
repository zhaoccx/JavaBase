package com.patterns.singleton;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 上午11:38:14
 */
public class Singleton1 {

	private static Singleton1 singleton1 = null;

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		if (null == singleton1) {
			singleton1 = new Singleton1();
		}
		return singleton1;
	}

	public void doMetheds() {
		System.out.println(this.hashCode());
		System.out.println(this.toString());
	}
}

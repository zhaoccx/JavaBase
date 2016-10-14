package com.patterns.singleton;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 上午11:50:58
 */
public class Singleton2 {

	private static Singleton2 singleton2 = new Singleton2();;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		return singleton2;
	}

	public void doMetheds() {
		System.out.println("22222222222222222");
		System.out.println(this.hashCode());
	}
}

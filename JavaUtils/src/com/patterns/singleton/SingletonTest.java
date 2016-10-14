package com.patterns.singleton;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 上午11:51:57
 */
public class SingletonTest {
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		singleton1.doMetheds();
		Singleton1 singleton2 = Singleton1.getInstance();
		singleton2.doMetheds();

		Singleton2 singleton3 = Singleton2.getInstance();
		singleton3.doMetheds();
		Singleton2 singleton4 = Singleton2.getInstance();
		singleton4.doMetheds();

	}
}

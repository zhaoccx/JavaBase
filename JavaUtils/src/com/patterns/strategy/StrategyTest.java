package com.patterns.strategy;

/**
 * @author zhaocc
 * @time 2016年10月14日 上午11:04:37
 */
public class StrategyTest {

	public static void main(String[] args) {
		Context context = new Context(new Strategy1());
		context.operate();
		System.out.println("*******************");
		context = new Context(new Strategy2());
		context.operate();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
		context = new Context(new Strategy3());
		context.operate();
		System.out.println("*******************");

	}
}

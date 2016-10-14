package com.patterns.strategy;

/**
 * @author zhaocc
 * @time 2016年10月14日 上午10:58:00
 */
public class Strategy3 implements IStrategy {

	/**
	 * 第一个方法
	 */
	@Override
	public void operate() {
		System.err.println(this.getClass().getName() + "............");
	}

}

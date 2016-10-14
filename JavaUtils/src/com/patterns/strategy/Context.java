package com.patterns.strategy;

/**
 * @author zhaocc
 * @time 2016年10月14日 上午11:00:40
 */
public class Context {
	private IStrategy iStrategy;

	/**
	 * 构造函数，并产生。。
	 * 
	 * @param iStrategy
	 */
	public Context(IStrategy iStrategy) {
		super();
		this.iStrategy = iStrategy;
	}

	/**
	 * 执行的方法
	 * 
	 * @author zhaocc
	 * @time 2016年10月14日 上午11:03:09
	 */
	public void operate() {
		this.iStrategy.operate();
	}
}

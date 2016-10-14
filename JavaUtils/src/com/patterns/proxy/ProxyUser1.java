package com.patterns.proxy;

/**
 * 默认被代理的对象1
 * 
 * @author zhaocc
 * @time 2016年10月14日 上午11:20:42
 */
public class ProxyUser1 implements IProxy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.proxy.IProxy#doSomething()
	 */
	@Override
	public void doSomething() {
		System.err.println(this.getClass().getName() + "... doSomething()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.proxy.IProxy#doAnything()
	 */
	@Override
	public String doAnything() {
		System.err.println(this.getClass().getName() + "... doAnything()");
		return this.getClass().getName() + "... doAnything()";
	}

}

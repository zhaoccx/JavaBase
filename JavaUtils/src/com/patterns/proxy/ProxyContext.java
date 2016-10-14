package com.patterns.proxy;

/**
 * 代理的对象
 * 
 * @author zhaocc
 * @time 2016年10月14日 上午11:20:42
 */
public class ProxyContext implements IProxy {
	public IProxy iproxy;

	/**
	 * 
	 */
	public ProxyContext() {
		super();
		this.iproxy = new ProxyDefalut();
	}

	/**
	 * @param iproxy
	 */
	public ProxyContext(IProxy iproxy) {
		super();
		this.iproxy = iproxy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.proxy.IProxy#doSomething()
	 */
	@Override
	public void doSomething() {
		this.iproxy.doSomething();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.proxy.IProxy#doAnything()
	 */
	@Override
	public String doAnything() {
		return this.iproxy.doAnything();
	}

}

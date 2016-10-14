package com.patterns.proxy;

/**
 * 测试代理
 * 
 * @author zhaocc
 * @time 2016年10月14日 上午11:28:27
 */
public class ProxyTest {
	public static void main(String[] args) {
		IProxy proxyContext = new ProxyContext();
		proxyContext.doSomething();
		proxyContext.doAnything();

		proxyContext = new ProxyContext(new ProxyUser1());
		proxyContext.doSomething();
		proxyContext.doAnything();
	}
}

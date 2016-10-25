package com.patterns.bridge;

/**
 *
 * @author zhaocc
 * @time 2016年10月20日 下午3:37:24
 */
public class IPod extends Product {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.bridge.Product#beProduct()
	 */
	@Override
	public void beProduct() {
		System.out.println(this.getClass().getName() + ".... beProduct ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.bridge.Product#beSell()
	 */
	@Override
	public void beSell() {
		System.out.println(this.getClass().getName() + ".... beSell ");
	}

}

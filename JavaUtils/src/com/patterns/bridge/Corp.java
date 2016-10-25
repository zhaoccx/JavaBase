package com.patterns.bridge;

/**
 *
 * @author zhaocc
 * @time 2016年10月20日 下午3:13:20
 */
public abstract class Corp {

	private Product product;

	/**
	 * @param product
	 */
	public Corp(Product product) {
		this.product = product;
	}

	public void makeMoney() {
		this.product.beProduct();
		this.product.beSell();
		System.out.println(this.getClass().getName() + "...... makeMoney");
	}

}

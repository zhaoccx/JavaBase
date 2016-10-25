package com.patterns.bridge;

/**
 *
 * @author zhaocc
 * @time 2016年10月20日 下午3:21:44
 */
public class HouseCorp extends Corp {

	/**
	 * @param product
	 */
	public HouseCorp(Cloths product) {
		super(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.bridge.Corp#makeMoney()
	 */
	@Override
	public void makeMoney() {
		super.makeMoney();
		System.out.println(this.getClass().getName() + "makeMoney");
	}

}

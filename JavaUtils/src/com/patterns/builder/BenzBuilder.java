package com.patterns.builder;

import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午4:00:54
 */
public class BenzBuilder extends CarBuilder {
	private BenzModel benz = new BenzModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.builder.CarBuilder#setSequence(java.util.List)
	 */
	@Override
	public void setSequence(List<Step> sequence) {
		this.benz.setSequece(sequence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.builder.CarBuilder#getCarModel()
	 */
	@Override
	public CarModule getCarModel() {
		return this.benz;
	}

}

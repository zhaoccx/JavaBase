package com.patterns.builder;

import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午4:04:58
 */
public class BMWBulider extends CarBuilder {
	private BMWModule bmwModule = new BMWModule();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.builder.CarBuilder#setSequence(java.util.List)
	 */
	@Override
	public void setSequence(List<Step> sequence) {
		this.bmwModule.setSequece(sequence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.builder.CarBuilder#getCarModel()
	 */
	@Override
	public CarModule getCarModel() {
		return this.bmwModule;
	}

}

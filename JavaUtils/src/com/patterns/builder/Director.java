package com.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午4:36:20
 */
public class Director {
	private List<Step> sequenct = new ArrayList<>();

	private CarBuilder benzbuilder = new BenzBuilder();

	private CarBuilder bmwBuilder = new BMWBulider();

	public CarModule getABenzModule() {
		this.sequenct.clear();

		this.sequenct.add(Step.start);

		this.sequenct.add(Step.stop);

		this.benzbuilder.setSequence(this.sequenct);
		return this.benzbuilder.getCarModel();
	}

	public CarModule getABMWModule() {
		this.sequenct.clear();

		this.sequenct.add(Step.alarm);

		this.sequenct.add(Step.engineBoom);

		this.bmwBuilder.setSequence(this.sequenct);
		return this.bmwBuilder.getCarModel();
	}
}

package com.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午3:24:17
 */
public class ModuleTest {
	public static void main(String[] args) {
		BenzModel benzModel = new BenzModel();
		List<Step> list = new ArrayList<>();
		list.add(Step.start);
		list.add(Step.engineBoom);
		benzModel.setSequece(list);
		benzModel.run();

		CarBuilder builder = new BenzBuilder();
		builder.setSequence(list);
		CarModule carModel = builder.getCarModel();
		carModel.run();

		CarBuilder bmwBulider = new BMWBulider();
		bmwBulider.setSequence(list);
		CarModule model = bmwBulider.getCarModel();
		model.run();

		System.out.println("---------------------------------");
		Director director = new Director();
		for (int i = 0; i < 100; i++) {
			director.getABenzModule().run();

		}
	}
}

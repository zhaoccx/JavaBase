package com.patterns.factory;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午4:20:14
 */
public class FactoryTest {
	public static void main(String[] args) {
		IHuman createHuman = HumanFactory.createHuman(Human1.class);
		createHuman.laugh();
		createHuman.cry();
		createHuman.talk();
		createHuman = HumanFactory.createHuman(Human2.class);
		createHuman.laugh();
		createHuman.cry();
		createHuman.talk();
		createHuman = HumanFactory.createHuman(Human3.class);
		createHuman.laugh();
		createHuman.cry();
		createHuman.talk();

		for (int i = 0; i < 1000; i++) {
			createHuman = HumanFactory.createHuman();

			createHuman.laugh();
			createHuman.cry();
			createHuman.talk();
		}
	}
}

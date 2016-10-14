package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:41:01
 */
public class AbstractHumanTest {
	public static void main(String[] args) {
		AbstractHumanFactory factoryFemale = new HumanFactoryFemale();

		AbstractHumanFactory factoryMale = new HumanFactoryMale();

		IHuman bHuman = factoryFemale.createBHuman();
		IHuman createBHuman = factoryMale.createBHuman();
		bHuman.laugh();
		createBHuman.talk();
	}
}

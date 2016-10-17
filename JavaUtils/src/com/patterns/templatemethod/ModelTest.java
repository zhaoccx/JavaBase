package com.patterns.templatemethod;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午1:57:55
 */
public class ModelTest {
	public static void main(String[] args) {
		Model1 model1 = new Model1();
		model1.setAlarm(true);
		model1.run();

		Model2 model2 = new Model2();
		model2.run();
	}
}

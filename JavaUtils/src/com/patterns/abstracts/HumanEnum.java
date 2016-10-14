package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:10:35
 */
public enum HumanEnum {
	AbstractHumanYFemale("com.patterns.abstracts.AbstractHumanYFemale"), AbstractHumanYMale("com.patterns.abstracts.AbstractHumanYMale"), AbstractHumanBFemale("com.patterns.abstracts.AbstractHumanBFemale"), AbstractHumanBMale("com.patterns.abstracts.AbstractHumanBMale"), AbstractHumanWFemale("com.patterns.abstracts.AbstractHumanWFemale"), AbstractHumanWMale(
			"com.patterns.abstracts.AbstractHumanWMale");

	private String value = "";

	// 定义构造函数，目的是Data(value)类型的相匹配
	private HumanEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

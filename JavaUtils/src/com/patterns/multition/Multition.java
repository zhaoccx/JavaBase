package com.patterns.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author zhaocc
 * @time 2016年10月14日 下午2:55:30
 */
public class Multition {

	private static int max = 3; // 最大数
	private static List<String> multNameList = new ArrayList<>(max); // 名字列表
	private static List<Multition> multitions = new ArrayList<>(max);// 实例列表
	private static int usecount = 0;// 正在用的数据

	static {
		for (int i = 0; i < max; i++) {
			multitions.add(new Multition("第" + (i + 1) + "个实例"));
		}
	}

	private Multition() {

	}

	private Multition(String name) {
		multNameList.add(name);
	}

	public static Multition getInstance() {
		Random random = new Random();
		usecount = random.nextInt(max);
		return multitions.get(usecount);
	}

	public static Multition getInstance(int x) {
		if (null == multitions.get(x)) {
			return getInstance();
		} else {
			return multitions.get(x);
		}
	}

	public void getMultionName() {
		System.out.println(multNameList.get(usecount));
	}
}

package com.zcc.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Title:全排列算法
 * </p>
 *
 * <p>
 * Copyright: http://blog.csdn.net/sunyujia/
 * </p>
 *
 * @author 孙钰佳
 * @main sunyujia@yahoo.cn
 * @date 2009-04-25 23:57:23 PM
 */
public class FullSort {
	// 将NUM设置为待排列数组的长度即实现全排列
	private static int NUM = 4;

	/**
	 * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列
	 *
	 * @param datas
	 * @param target
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void sort(List datas, List target) {
		if (target.size() == NUM) {
			for (Object obj : target)
				System.out.print(obj);
			System.out.println();
			System.out.println();
			return;
		}
		for (int i = 0; i < datas.size(); i++) {
			List newDatas = new ArrayList(datas);
			List newTarget = new ArrayList(target);
			newTarget.add(newDatas.get(i));
			newDatas.remove(i);
			sort(newDatas, newTarget);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		String[] datas = "3de0 7d3c 6d47 53dd".split(" ");
		sort(Arrays.asList(datas), new ArrayList());
	}
	
//	@SuppressWarnings("rawtypes")
//	public static void main(String[] args) {
//		String datas = "1c@69#928f99c089";
//		String [] se = {"a","b","c","d","e","f"};
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 6; j++) {
//				System.out.println(datas.replaceAll("@", se[i]).replaceAll("#", se[i]));
//				System.out.println();
//			}
//		}
//	}

}

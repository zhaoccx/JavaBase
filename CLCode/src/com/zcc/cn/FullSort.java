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
	private static void sort(List<String> datas, List<String> target) {
		System.err.println(System.currentTimeMillis());
		if (target.size() == NUM) {
			for (Object obj : target){
				System.out.print(obj);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < datas.size(); i++) {
			List<String> newDatas = new ArrayList<String>(datas);
			List<String> newTarget = new ArrayList<String>(target);
			newTarget.add(newDatas.get(i));
			newDatas.remove(i);
			sort(newDatas, newTarget);
		}
	}

	public static void main(String[] args) {
		 String[] datas = "3173 fae3 a741 796d".split(" ");
		 sort(Arrays.asList(datas), new ArrayList<String>());
//		stringReplace();
//		for (String string : targets) {
//			System.out.println(string + "SSS");
//		}
	}

	public static List<String> getList(String str){
//		List<String> list = new ArrayList<String>();
		String[] datas = "str".split(" ");
		sort(Arrays.asList(datas), new ArrayList<String>());
		
		return null;
	}
	
	
	
	public static void stringReplace() {
		String string1;
		String string2;
		String datas = "6ac8 7@b3 d020 c#ef";
		String[] se = { "a", "b", "c", "d", "e", "f" };
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (i >= 10) {
					string1 =se[i-10];
				}else{
					string1 = i+"";
				}
				if (j >= 10) {
					string2 =se[j-10];
				}else{
					string2 = j+"";
				}
				getList(datas.replaceAll("@", string1).replaceAll("#", string2));
				System.out.println(datas.replaceAll("@", string1).replaceAll("#", string2));
				System.out.println();
			}
		}
	}
	
	public static List<String> stringReplace(String datas) {
		List<String> list = new ArrayList<String>();
		String string1;
		String string2;
//		String datas = "6ac8 7@b3 d020 c#ef";
		String[] se = { "a", "b", "c", "d", "e", "f" };
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (i >= 10) {
					string1 =se[i-10];
				}else{
					string1 = i+"";
				}
				if (j >= 10) {
					string2 =se[j-10];
				}else{
					string2 = j+"";
				}
				System.out.println(datas.replaceAll("@", string1).replaceAll("#", string2));
				System.out.println();
				list.add(datas.replaceAll("@", string1).replaceAll("#", string2));
			}
		}
		return list;
	}

}

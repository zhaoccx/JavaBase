package com.zcc.cn;

public class Numberlowone {
	public static void main(String[] args) {

		numberAddsomeLists("1aaeb20d831cf710", 1);

	}

	/**
	 * 数字加某一个加some;
	 * 
	 * @param strs
	 *            源字符
	 * @param some
	 *            要加的数字
	 */
	public static void numberAddsomeLists(String strs, int some) {
		char[] charArray = strs.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				int s = Integer.parseInt(charArray[i] + "");
				s += some;
				s %= 10;
				if (s < 0) {
					s += 10;
				}
				numberAddSome(strs, i, s);
			} catch (Exception e) {

			}
		}

	}

	public static void numberAddSome(String strs, int index, int value) {
		StringBuffer buff = new StringBuffer();
		char[] charArray = strs.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i == index) {
				buff.append(value);
			} else {
				buff.append(charArray[i]);
			}
		}
		System.out.println(buff.toString());
		System.out.println();
	}
}

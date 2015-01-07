package com.zcc.cn;

public class Numberlowone {
	public static void main(String[] args) {

		numberAddsome("1aaeb20d831cf710", 5);

	}

	public static void numberAddsome(String strs, int some) {
		StringBuffer buff = new StringBuffer();
		char[] charArray = strs.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				int s = Integer.parseInt(charArray[i] + "");
				s += some;
				s %= 10;
				if (s < 0) {
					s += 10;
				}
				
				buff.append(s);
			} catch (Exception e) {
				buff.append(charArray[i]);
			}
		}

		System.out.println(buff.toString());

	}
}

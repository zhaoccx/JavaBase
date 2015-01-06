package com.zcc.cn;

public class Numberlowone {
	public static void main(String[] args) {

		sysCode("1aaeb20d831cf710");

	}

	public static void sysCode(String strs) {
		StringBuffer buff = new StringBuffer();
		char[] charArray = strs.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				int s = Integer.parseInt(charArray[i] + "");
				if (s == 0) {
					s = 9;
				} else if (s == 9) {
					s = 0;
				}else{
					s++;
				}
				buff.append(s);
			} catch (Exception e) {
				buff.append(charArray[i]);
			}
		}
		
		System.out.println(buff.toString());

	}
}

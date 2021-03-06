package com.zcc.cn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;


public class Numberlowone {
	public static void main(String[] args) {

		numberAddsomeLists("352830eec7509cd8", -1);
//		System.out.println("******************************");
//		charAddsomeLists("1aaeb20d831cf710", 3);
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

	/**
	 * 字符加某一个加some;
	 * 
	 * @param strs
	 *            源字符
	 * @param some
	 *            要加的数字
	 */
	public static void charAddsomeLists(String strs, int some) {
		char[] charArray = strs.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				Integer.parseInt(charArray[i] + "");
			} catch (Exception e) {
				int s = charArray[i];
				s += some;
				if (s < 97) {
					s += 6;
				} else if (s > 102) {
					s -= 6;
				}
				numberAddSomeChar(strs, i, (char) s);
			}
		}

	}

	/**
	 * 数字加
	 * 
	 * @param strs
	 * @param index
	 * @param value
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static List<String> numberAddSome(String strs, int index, int value) throws ClientProtocolException, IOException {
		List<String> list = new ArrayList<String>();
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
		
		Client1024.regis(buff.toString());
		list.add(buff.toString());
		
		System.out.println();
		return list;
	}

	/**
	 * 字符加
	 * 
	 * @param strs
	 * @param index
	 * @param value
	 */
	public static void numberAddSomeChar(String strs, int index, char value) {
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

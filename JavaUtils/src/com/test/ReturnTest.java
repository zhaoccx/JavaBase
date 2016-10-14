package com.test;

/**
 * @author zhaocc
 *
 */
public class ReturnTest {
	public static void main(String[] args) {
		System.out.println("VVVVVVVVVVVVVVVVVV");
		System.out.println(getMessage());
		System.out.println(new ReturnTest().getMessages());
	}

	public static String getMessage() {
		String string = "0";
		try {
			return string;
		} finally {
			System.out.println("sssssssssssssssss+sssssssssss");
			string = "1";
		}
	}

	public String getMessages() {
		String string = "5";
		try {
			return string;
		} finally {
			System.out.println("sssssssssssssssss+sssssssssss");
			string = "4";
		}
	}
}

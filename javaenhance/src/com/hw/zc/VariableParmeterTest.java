package com.hw.zc;

public class VariableParmeterTest {

	public static void main(String[] args) {
		System.out.println(add(0, 2, 2, 3, 33, 3, 3, 3, 3, 3));
		System.out.println(add2(0, 2, 2, 3, 33, 3, 3, 3, 3, 3));
	}

	public static int add(int x, int... is) {
		for (int i = 0; i < is.length; i++) {
			x += is[i];
		}
		return x;
	}

	public static int add2(int x, int... is) {
		for (int i : is) {
			x += i;
		}
		return x;
	}

}

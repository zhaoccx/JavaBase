package com.zcc.fab;

public class Fab {
	public static void main(String[] arg) {
		System.out.println(System.currentTimeMillis());
		System.out.println(f(500));
		System.out.println(System.currentTimeMillis());
		System.out.println(rcv(40));
		System.out.println(System.currentTimeMillis());
	}

	public static long f(int index) {
		if (index == 1 || index == 2) {
			return 1;
		}

		long f1 = 1L;
		long f2 = 1L;
		long fall = 0;
		for (int i = 0; i < index - 2; i++) {
			fall = f1 + f2;
			f1 = f2;
			f2 = fall;

		}

		return fall;
	}

	public static long rcv(int index) {

		if (index == 1 || index == 2) {
			return 1;

		}
		return rcv(index - 1) + rcv(index - 2);
	}
}

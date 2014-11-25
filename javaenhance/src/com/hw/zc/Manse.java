package com.hw.zc;

import java.util.Scanner;

public class Manse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		if ("123".equals(next)) {
			System.out.println(true);
		} else {
			System.err.println(false);
		}
		scanner.close();
	}
}

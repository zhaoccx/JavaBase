/**
 * 
 */
package com.arithmetic.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhaocc
 *
 */
public class ThreeColorsFlags {
	private void swap(char[] flags, int x, int y) {
		char temp;
		temp = flags[x];
		flags[x] = flags[y];
		flags[y] = temp;
	}

	public String move(char[] flags) {
		int wFlag = 0;
		int bFlag = 0;
		int rFlag = flags.length - 1;

		while (wFlag <= rFlag) {
			if (flags[wFlag] == 'W') {
				wFlag++;
			} else if (flags[wFlag] == 'B') {
				swap(flags, bFlag, wFlag);
				bFlag++;
				wFlag++;
			} else {
				while (wFlag < rFlag && flags[rFlag] == 'R')
					rFlag--;
				swap(flags, rFlag, wFlag);
				rFlag--;
			}
		}

		return new String(flags);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("输入三色棋顺序（ex. RWBBWRWR）：");
		String flags = buf.readLine();

		ThreeColorsFlags threeColorsFlag = new ThreeColorsFlags();
		flags = threeColorsFlag.move(flags.toUpperCase().toCharArray());

		System.out.println("移动顺序后：" + flags);
	}
}

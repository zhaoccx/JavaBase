/**
 * 
 */
package com.arithmetic.old;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author zhaocc
 *
 */

public class Pascal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1219003158393480579L;

	public Pascal() {
		setBackground(Color.white);
		setTitle("巴斯卡三角形");
		setSize(520, 350);
		setLocation(getWidth() / 2, getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private long combi(int n, int r) {
		int i;
		long p = 1;

		for (i = 1; i <= r; i++)
			p = p * (n - i + 1) / i;

		return p;
	}

	public void paint(Graphics g) {
		final int N = 12;
		int n, r;

		for (n = 0; n <= N; n++) {
			for (r = 0; r <= n; r++)
				g.drawString(" " + combi(n, r), (N - n) * 20 + r * 40, n * 20 + 50);
		}
	}

	public static void main(String args[]) {
		new Pascal();
	}
}
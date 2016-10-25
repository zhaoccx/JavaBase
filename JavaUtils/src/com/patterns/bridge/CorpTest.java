package com.patterns.bridge;

/**
 *
 * @author zhaocc
 * @time 2016年10月20日 下午3:25:36
 */
public class CorpTest {
	public static void main(String[] args) {
		new ClothsCorp(new Cloths()).makeMoney();
	}
}

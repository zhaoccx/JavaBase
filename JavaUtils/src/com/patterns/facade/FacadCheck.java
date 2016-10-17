package com.patterns.facade;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午9:22:43
 */
public class FacadCheck {
	public void checkContext(String cString) {
		System.out.println(this.getClass().getName() + "checkContext" + cString);
	}
}

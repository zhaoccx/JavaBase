package com.patterns.adapter;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午10:23:00
 */
public class UserTest {
	public static void main(String[] args) {
		// IUserInfo info = new UserInfo();
		// for (int i = 0; i < 10; i++) {
		// info.getMobileNumber();
		// }
		IUserInfo info = new OutInfoAdapter();
		for (int i = 0; i < 10; i++) {
			info.getMobileNumber();
			info.getUserName();
		}
	}
}

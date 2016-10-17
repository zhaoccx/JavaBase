package com.patterns.adapter;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午10:13:14
 */
public class UserInfo implements IUserInfo {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		System.out.println(this.getClass().getName() + "getUserName");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getHomeAddress()
	 */
	@Override
	public String getHomeAddress() {
		System.out.println(this.getClass().getName() + "getHomeAddress");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		System.out.println(this.getClass().getName() + "getMobileNumber");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getOfficeTelNumber()
	 */
	@Override
	public String getOfficeTelNumber() {
		System.out.println(this.getClass().getName() + "getOfficeTelNumber");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getJobPosition()
	 */
	@Override
	public String getJobPosition() {
		System.out.println(this.getClass().getName() + "getJobPosition");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getHomeTelNumber()
	 */
	@Override
	public String getHomeTelNumber() {
		System.out.println(this.getClass().getName() + "getHomeTelNumber");
		return null;
	}

}

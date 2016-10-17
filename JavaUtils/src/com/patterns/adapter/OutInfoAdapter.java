package com.patterns.adapter;

import java.util.Map;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午10:39:30
 */
public class OutInfoAdapter extends OutUserImpl implements IUserInfo {

	private Map<String, String> baseInfo = super.getUserBaseInfo();
	private Map<String, String> homeInfo = super.getUserHomeInfo();
	private Map<String, String> officeInfo = super.getUserOfficeInfo();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		String username = this.baseInfo.get("userName");
		System.out.println(username + "....." + this.getClass().getName());
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getHomeAddress()
	 */
	@Override
	public String getHomeAddress() {
		String homeAddress = this.homeInfo.get("homeAddress");
		System.out.println(homeAddress + "....." + this.getClass().getName());
		return homeAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		String mobileNumber = this.baseInfo.get("mobileNumber");
		System.out.println(mobileNumber + "....." + this.getClass().getName());
		return mobileNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getOfficeTelNumber()
	 */
	@Override
	public String getOfficeTelNumber() {
		String officeTelNumber = this.officeInfo.get("officeTelNumber");
		System.out.println(officeTelNumber + "....." + this.getClass().getName());
		return officeTelNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getJobPosition()
	 */
	@Override
	public String getJobPosition() {
		String jobPosition = this.officeInfo.get("jobPosition");
		System.out.println(jobPosition + "....." + this.getClass().getName());
		return jobPosition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IUserInfo#getHomeTelNumber()
	 */
	@Override
	public String getHomeTelNumber() {
		String homeTelNumber = this.homeInfo.get("homeTelNumber");
		System.out.println(homeTelNumber + "....." + this.getClass().getName());
		return homeTelNumber;
	}

}

package com.patterns.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午10:28:58
 */
public class OutUserImpl implements IOutUser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IOutUser#getUserBaseInfo()
	 */
	@Override
	public Map<String, String> getUserBaseInfo() {
		Map<String, String> map = new HashMap<>();
		map.put("userName", this.getClass().getName() + "getUserBaseInfo....userName...");
		map.put("mobileNumber", this.getClass().getName() + "getUserBaseInfo....mobileNumber...");
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IOutUser#getUserOfficeInfo()
	 */
	@Override
	public Map<String, String> getUserOfficeInfo() {
		Map<String, String> map = new HashMap<>();
		map.put("jobPosition", this.getClass().getName() + "getUserOfficeInfo....jobPosition...");
		map.put("officeTelNumber", this.getClass().getName() + "getUserOfficeInfo....officeTelNumber...");
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.adapter.IOutUser#getUserHomeInfo()
	 */
	@Override
	public Map<String, String> getUserHomeInfo() {
		Map<String, String> map = new HashMap<>();
		map.put("homeTelNumber", this.getClass().getName() + "getUserHomeInfo....homeTelNumber...");
		map.put("homeAddress", this.getClass().getName() + "getUserHomeInfo....homeAddress...");
		return map;
	}

}

package com.patterns.adapter;

import java.util.Map;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午10:25:52
 */
public interface IOutUser {

	public Map<String, String> getUserBaseInfo();

	public Map<String, String> getUserOfficeInfo();

	public Map<String, String> getUserHomeInfo();

}

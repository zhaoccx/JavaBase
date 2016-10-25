package com.patterns.iterator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午5:26:41
 */
public interface IProject {

	public String getProjectInfo();

	public void add(String name, int num, int cost);

	public IProjectIterator iterator();
}

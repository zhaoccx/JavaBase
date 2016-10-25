package com.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午5:28:52
 */
public class Project implements IProject {

	private List<IProject> projects = new ArrayList<>();

	private String name = "";
	private int num = 0;
	private int cost = 0;

	public Project() {
		super();
	}

	/**
	 * @param name
	 * @param num
	 * @param cost
	 */
	private Project(String name, int num, int cost) {
		super();
		this.name = name;
		this.num = num;
		this.cost = cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.iterator.IProject#getProjectInfo()
	 */
	@Override
	public String getProjectInfo() {
		String info = "";
		// 获得项目的名称
		info = info + "项目名称是：" + this.name;
		// 获得项目人数
		info = info + "\t项目人数: " + this.num;
		// 项目费用
		info = info + "\t 项目费用：" + this.cost;
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.iterator.IProject#add(java.lang.String, int, int)
	 */
	@Override
	public void add(String name, int num, int cost) {
		this.projects.add(new Project(name, num, cost));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.iterator.IProject#iterator()
	 */
	@Override
	public IProjectIterator iterator() {
		return new ProjectIterator(this.projects);
	}

}

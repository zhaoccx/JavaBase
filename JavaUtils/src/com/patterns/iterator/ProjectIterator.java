package com.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月25日 下午3:40:41
 */
public class ProjectIterator implements IProjectIterator {

	private List<IProject> projectlist = new ArrayList<>();

	private int currentItem = 0;

	public ProjectIterator(List<IProject> projectlist) {
		this.projectlist = projectlist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		boolean flag = true;
		if (this.currentItem >= this.projectlist.size() || null == this.projectlist.get(this.currentItem)) {
			flag = false;
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public IProject next() {
		return this.projectlist.get(this.currentItem++);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}

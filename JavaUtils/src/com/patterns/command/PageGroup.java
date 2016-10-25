package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午10:57:03
 */
public class PageGroup extends Group {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Group#find()
	 */
	@Override
	public void find() {
		System.out.println(this.getClass().getName() + "  ... find ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Group#add()
	 */
	@Override
	public void add() {
		System.out.println(this.getClass().getName() + "  ... add ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Group#delete()
	 */
	@Override
	public void delete() {
		System.out.println(this.getClass().getName() + "  ... delete ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Group#change()
	 */
	@Override
	public void change() {
		System.out.println(this.getClass().getName() + "  ... change ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Group#plan()
	 */
	@Override
	public void plan() {
		System.out.println(this.getClass().getName() + "  ... plan ");
	}

}

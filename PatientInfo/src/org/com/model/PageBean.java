package org.com.model;

public class PageBean {
	private int page;// 第几页
	private int rows;// 每页记录数
	private int start;// 起始页

	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public int getPages() {
		return page;
	}

	public void setPages(int pages) {
		this.page = pages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (page - 1) * rows;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStarts() {
		return this.start;

	}
}

package com.patterns.decorator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午3:05:34
 */
public class Decorator extends Report {

	private Report report;

	/**
	 * 
	 */
	public Decorator(Report report) {
		this.report = report;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.Report#report()
	 */
	@Override
	public void report() {
		this.report.report();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.Report#sign()
	 */
	@Override
	public void sign() {
		this.report.sign();
	}

}
